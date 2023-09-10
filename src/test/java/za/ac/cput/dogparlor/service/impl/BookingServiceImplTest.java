package za.ac.cput.dogparlor.service.impl;

import org.junit.Test;
import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.service.IBookingService;
import za.ac.cput.dogparlor.service.IService;

import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookingServiceImplTest {


    private final BookingServiceImplTest booking = null;

    @Test
    void a_create(Object IBookingService) {

        Booking booking1 = null;
        booking.a_create(IBookingService);
        assertNotNull(booking1);
        System.out.println("Created: " + booking1);
    }

    @Test
    void b_read() {
        IBookingService booking1;
        booking1 = booking.read(booking.getBookingID());
        assertNotNull(booking1);
        System.out.println("Read: " + booking1);
    }

    private IBookingService read(Object bookingID) {
        return null;
    }

    @Test
    void c_update(Booking booking1, Booking IBookingService) {
        booking1 = new Booking.BookingBuilder().copy(IBookingService)
                .setBookingID(String.valueOf(546))
                .build();
        Object updated = IService.update(booking1);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean deleted = IService.delete(IBookingService.getBookingID());
        assertTrue(deleted);
        System.out.println("Deleted: " + (deleted ? "Yes" : "No"));
    }

    private Object getBookingID() {
        return null;
    }

    @Test
    void d_getAll() {
        int bookings;
        bookings = IBookingService.getAllBookings();
        assertNotNull(bookings);
        System.out.println("All items: " + bookings);
    }
}