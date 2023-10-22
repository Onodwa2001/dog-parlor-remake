/* StaffRepository.java
  Entity for the Staff
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.dogparlor.domain.Staff;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {

    Optional<Staff> getStaffByUser_Username(String username);

}
