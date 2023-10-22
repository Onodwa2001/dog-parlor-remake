package za.ac.cput.dogparlor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> getCustomerByUser_Username(String username);

}
