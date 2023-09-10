package za.ac.cput.dogparlor.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.orm.hibernate5.HibernateOperations;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.factory.CustomerFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerBookingServiceImplTest {

    private final CustomerService customer = CustomerServiceImpl.getInstance();

    @Test
    void create() {
        int customer = null;
        customer = customer;
        assertNotNull(customer);
        System.out.println("Created: " + customer);
    }

    @Test
    void read() {
        Customer customerBooking1 = customer.read(customer.getCustomerID());
        assertNotNull(customerBooking1);
        System.out.println("Read: " + customerBooking1);
    }

    private void assertNotNull(Customer customerBooking1) {
    }

    @Test
    void update() {
        HibernateOperations customerService = null;
        Customer customer1 = null;
        customerService.update(customer);
        assertNotNull(customer1);
        System.out.println("Updated: " + customer1);
    }

    @Test
    void delete() {
        boolean deleted = customer.delete(customer.getCustomerID());
        assertTrue(deleted);
        System.out.println("Deleted: " + (deleted ? "Yes" : "No"));
    }

    @Test
    void getAll() {
        Set<Customer> customer = null;
        customer = customer.getAll;
        assertNotNull((Customer) customer);
        System.out.println("All CustomerBookings: " + customer);
    }

    private static class CustomerServiceImpl {
        public static CustomerService getInstance() {
            CustomerService instance = null;
            return instance;
        }
    }
}
