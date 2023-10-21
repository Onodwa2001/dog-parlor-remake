/* BookingController.java
  Entity for the Booking
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.factory.BookingFactory;
import za.ac.cput.dogparlor.service.impl.BookingService;
import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    // customer
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('USER')")
    public Booking createBooking(@RequestBody Booking booking){
        String dateString = booking.getBookingDate().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);

        Booking createdBooking = BookingFactory.createBooking(dateTime, booking.getDog(),
                booking.getStaffList(), booking.getGroomServices(), booking.getExtraServices(), booking.getTotal());
        System.out.println(createdBooking);

        return bookingService.create(createdBooking);
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Booking updateBooking(@RequestBody Booking booking) {
        return bookingService.update(booking);
    }

    // customer and admin
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public boolean deleteBooking(@PathVariable String id) {
        return bookingService.delete(id);
    }

    // admin
    @GetMapping("/getall")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }


    @PostMapping("/unavailable-dates")
    public HashMap<String, Integer> getUnavailableDates(@RequestBody ArrayList<String> monthYearStringParam) {
        HashMap<String, Integer> result;
        try {
            result = bookingService.getUnavailableDates(monthYearStringParam);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @PostMapping("is-fully-booked")
    public boolean isFullyBooked(@RequestParam String dateParam) {
        LocalDateTime date = LocalDateTime.parse(dateParam);
        return bookingService.isDayFullyBooked(date);
    }

    @GetMapping("/get-dates")
    public List<LocalDateTime> getDates() {
        return bookingService.getAllDatesOnLatestDay();
    }
}
