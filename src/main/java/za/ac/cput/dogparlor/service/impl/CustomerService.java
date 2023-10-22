package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.repository.CustomerRepository;
import za.ac.cput.dogparlor.service.ICustomerService;

import java.util.List;

@Component
@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository repository;

    @Autowired
    private CustomerService(CustomerRepository customerRepository) {
        this.repository = customerRepository;
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

    public Customer getCustomerByUsername(String username) {
        return repository.getCustomerByUser_Username(username).orElse(null);
    }

    @Override
    public Customer getCustomerIfExists(Contact contactParam) {
        List<Customer> customers = getAll();
        Customer retrievedCustomer = null;

        for (Customer customer : customers) {
            for (Contact contact : customer.getContacts()) {
                if (contact.getContactValue().equals(contactParam.getContactValue())) {
                    retrievedCustomer = customer;
                    break;
                }
            }
        }

        return retrievedCustomer;
    }

    public void deleteContactFromCustomer(String customerId, String contactId) {
        // Retrieve the customer entity
        Customer optionalCustomer = repository.findById(customerId).orElse(null);

        if (optionalCustomer != null) {

            // Retrieve the contact list from the customer
            List<Contact> contacts = optionalCustomer.getContacts();

            // Find the contact to be deleted
            Contact contactToBeDeleted = null;
            for (Contact contact : contacts) {
                if (contact.getContactValue().equals(contactId)) {
                    contactToBeDeleted = contact;
                    break;
                }
            }

            if (contactToBeDeleted != null) {
                // Remove the contact from the list
                contacts.remove(contactToBeDeleted);

                // Update the customer entity
                Customer newCustomer = new Customer.Builder().copy(optionalCustomer).setContacts(contacts).build();
                repository.save(newCustomer);
            } else {
                // Handle case when contact is not found
                // Perhaps throw an exception or handle accordingly
            }
        } else {
            // Handle case when customer is not found
            // Perhaps throw an exception or handle accordingly
        }
    }

}


