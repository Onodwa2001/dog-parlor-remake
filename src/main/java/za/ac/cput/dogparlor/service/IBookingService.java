package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Booking;

import java.util.List;

public interface IBookingService extends IService<Booking, String> {
    List<Booking> getAll();
}
