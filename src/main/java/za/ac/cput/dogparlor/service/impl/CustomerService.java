package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.repository.ContactRepository;
import za.ac.cput.dogparlor.repository.CustomerRepository;
import za.ac.cput.dogparlor.service.ICustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository repository;
    private final ContactService contactService;

    @Autowired
    private CustomerService(CustomerRepository customerRepository, ContactService contactService) {
        this.repository = customerRepository;
        this.contactService = contactService;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if (repository.existsById(customer.getCustomerID()))
            return repository.save(customer);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

//    @Override
//    public Customer getCustomerIfExists(Contact contactParam) {
//        List<Contact> contacts = contactService.getAll();
//        Contact retrievedCustomer = null;
//        for (Contact contact : contacts) {
//            if (contact.getContactValue().equals(contactParam.getContactValue()))
//                retrievedCustomer = contact;
//        }
//        System.out.println(retrievedCustomer);
//    }

}
