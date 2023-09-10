package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.*;
import za.ac.cput.dogparlor.util.Helper;

import java.time.LocalDateTime;
import java.util.List;

public class BookingFactory {

    public static Booking createBooking(Customer customer, List<Staff> staffList,
                                        List<GroomService> groomServices, List<ExtraService> extraServices, double total) {

        if (groomServices.isEmpty())
            return null;

        if (total < 1)
            return null;

        String bookingID = Helper.generateID();

        LocalDateTime bookingDate = LocalDateTime.now();

        return new Booking.Builder()
                .setBookingID(bookingID)
                .setBookingDate(bookingDate)
                .setCustomer(customer)
                .setStaffList(staffList)
                .setGroomServices(groomServices)
                .setExtraServices(extraServices)
                .setTotal(total)
                .build();
    }

    public static void createBooking(String zee, String number, String number1, String washing) {
    }
}
