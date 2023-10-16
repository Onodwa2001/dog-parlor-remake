/* BookingController.java
  Entity for the Booking
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.factory.BookingFactory;
import za.ac.cput.dogparlor.service.impl.BookingService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public Booking createBooking(@RequestBody Booking booking){
        System.out.println(booking);
        Booking createdBooking = BookingFactory.createBooking(booking.getDog(),
                booking.getStaffList(), booking.getGroomServices(), booking.getExtraServices(), booking.getTotal());
        System.out.println(createdBooking);

        return bookingService.create(createdBooking);
    }

    @PostMapping("/update")
    public Booking updateBooking(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBooking(@PathVariable String id) {
        return bookingService.delete(id);
    }

    @GetMapping("/getall")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }
}
