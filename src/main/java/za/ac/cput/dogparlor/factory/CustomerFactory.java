package za.ac.cput.dogparlor.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.ac.cput.dogparlor.domain.Address;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.User;
import za.ac.cput.dogparlor.util.Helper;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerFactory {

    public static Customer createCustomer(User user, String firstName, String lastName, List<Contact> contacts,
                                          List<Address> addresses) {

        if ((Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(user.getUsername()) || Helper.isNullOrEmpty(user.getPassword())))
            return null;

        String customerID = Helper.getCustomerID();

        return new Customer.Builder()
                .setCustomerID(customerID)
                .setUser(user)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContacts(contacts)
                .setAddresses(addresses)
                .build();

    }

}
