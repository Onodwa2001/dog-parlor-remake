/* BookingService.java
  Entity for the Booking
  Author: Byron Young (218155077)
  Date:27 August 2023
 */

package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.repository.BookingRepository;
import za.ac.cput.dogparlor.service.IBookingService;

import java.util.List;
@Service
public class BookingService implements IBookingService {

    private final BookingRepository repository;
    @Autowired
    private BookingService(BookingRepository bookingRepository){this.repository = bookingRepository;}

    @Override
    public Booking create(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public Booking read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {
        if (repository.existsById(booking.getBookingID()))
            return repository.save(booking);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;

        }
        return false;
    }

    @Override
    public List<Booking> getAll() {
        return repository.findAll();
    }
}
