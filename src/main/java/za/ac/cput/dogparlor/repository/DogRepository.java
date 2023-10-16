/* DogRepository.java
  Entity for the Dog
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.Dog;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, String> {

    List<Dog> getDogByCustomer(Customer customer);

}
