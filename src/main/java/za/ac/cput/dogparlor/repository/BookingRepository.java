/* BookingRepository.java
  Entity for the Booking
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.domain.Staff;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    Optional<List<Booking>> getBookingsByStaffListContaining(Staff staff);
}
