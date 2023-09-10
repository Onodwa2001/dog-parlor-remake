package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Booking;

import java.util.List;

public interface IBookingService extends IService<Booking, String> {
    static int getAllBookings() {
        return 0;
    }

    static Object getBookingID() {
        return null;
    }

    List<Booking> getAll();
}
