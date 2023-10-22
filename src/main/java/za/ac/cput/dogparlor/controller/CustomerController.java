package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.ContactType;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.User;
import za.ac.cput.dogparlor.dto.AuthRequest;
import za.ac.cput.dogparlor.factory.*;
import za.ac.cput.dogparlor.service.impl.AddressService;
import za.ac.cput.dogparlor.service.impl.ContactService;
import za.ac.cput.dogparlor.service.impl.CustomerService;
import za.ac.cput.dogparlor.service.impl.JwtService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PasswordEncoder encoder;


    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        String username = customer.getUser().getUsername();
        String encodedPassword = encoder.encode(customer.getUser().getPassword());
        User user = UserFactory.createUser(username, encodedPassword, customer.getUser().getRole());

        addressService.create(customer.getAddresses());
        contactService.create(customer.getContacts());

        System.out.println(user);
        Customer customer1 = CustomerFactory.createCustomer(user,
                customer.getFirstName(), customer.getLastName(),
                customer.getContacts(), customer.getAddresses());
        System.out.println(customer1);
        return customerService.create(customer1);
    }

    // admin
    @GetMapping("/read/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Customer readCustomer(@PathVariable String id) {
        return customerService.read(id);
    }

    @PostMapping("/login")
    public Customer login(@RequestBody Contact contact) {
        return customerService.getCustomerIfExists(contact);
    }

    // customer
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('USER')")
    public Customer updateCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        return customerService.update(customer);
    }

    // admin
    @DeleteMapping("/delete/{id}")
    public boolean deleteCustomer(@PathVariable String id) {
        Customer customer = customerService.read(id);
        for (Contact contact : customer.getContacts()) {
            customerService.deleteContactFromCustomer(customer.getCustomerID(), contact.getContactValue());
        }
//        contactService.deleteAll(customer.getContacts());
//        addressService.deleteAll(customer.getAddresses());
        return customerService.delete(id);
    }

    @GetMapping("/getall")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

}
