package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.factory.BookingFactory;
import za.ac.cput.dogparlor.service.impl.BookingService;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public Booking createBooking(@RequestParam Booking booking){
        Booking createdBooking = BookingFactory.createBooking(booking.getStaffID(), booking.getBookingDate(),booking.getServices(),booking.getTotal());
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
