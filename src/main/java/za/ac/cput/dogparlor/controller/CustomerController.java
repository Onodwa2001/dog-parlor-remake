package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.ContactType;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.factory.*;
import za.ac.cput.dogparlor.service.impl.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        Customer customer1 = CustomerFactory.createCustomer(customer.getFirstName(), customer.getLastName(),
                customer.getContacts(), customer.getAddresses());
        System.out.println(customer1);
        return customerService.create(customer1);
    }

    @GetMapping("/read/{id}")
    public Customer readCustomer(@PathVariable String id) {
        return customerService.read(id);
    }

    @PostMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteCustomer(@PathVariable String id) {
        return customerService.delete(id);
    }

    @GetMapping("/getall")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

}
