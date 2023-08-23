package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.domain.GroomService;
import za.ac.cput.dogparlor.domain.Staff;
import za.ac.cput.dogparlor.util.Helper;

import java.time.LocalDateTime;
import java.util.List;

public class BookingFactory {

    public static Booking createBooking(List<Staff> staff, LocalDateTime bookingDate,
                                        List<GroomService> groomServices, double total) {

        if (staff == null)
            return null;

        if (bookingDate == null || (Helper.isNullOrEmpty(bookingDate.getMonth().toString())))
            return null;

        if (groomServices == null)
            return null;

        if (total < 1)
            return null;

        String bookingID = Helper.generateID();

        return new Booking.Builder()
                .setBookingID(bookingID)
                .setStaff(staff)
                .setBookingDate(bookingDate)
                .setServices(groomServices)
                .setTotal(total)
                .build();
    }

}
