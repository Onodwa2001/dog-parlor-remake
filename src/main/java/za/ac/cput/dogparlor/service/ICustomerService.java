package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerService extends IService<Customer, String> {

    List<Customer> getAll();

}
