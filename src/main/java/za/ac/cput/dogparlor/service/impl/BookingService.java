/* BookingService.java
  Entity for the Booking
  Author: Byron Young (218155077)
  Date:27 August 2023
 */

package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.domain.Staff;
import za.ac.cput.dogparlor.repository.BookingRepository;
import za.ac.cput.dogparlor.service.IBookingService;
import za.ac.cput.dogparlor.util.Helper;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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

    public List<Booking> getBookingsByStaffListContaining(Staff staff) {
        return repository.getBookingsByStaffListContaining(staff).orElse(null);
    }

    public boolean isDayFullyBooked(LocalDateTime dateTime) {
        // The desired day
        int desiredYear = dateTime.getYear();
        int desiredMonth = dateTime.getMonthValue();
        int desiredDay = dateTime.getDayOfMonth();

        List<Booking> bookingsOnLatestDay = repository.findAll().stream().filter(date ->
                date.getBookingDate().getYear() == desiredYear &&
                date.getBookingDate().getMonthValue() == desiredMonth &&
                date.getBookingDate().getDayOfMonth() == desiredDay).toList();

        return bookingsOnLatestDay.size() >= 10;
    }

    public HashMap<String, Integer> getUnavailableDates(ArrayList<String> monthAndYear) throws Exception {
        int desiredMonth = Helper.getMonthNumberFromValue(monthAndYear.get(0));
        int desiredYear = Integer.parseInt(monthAndYear.get(1));

        if (desiredMonth == -1) {
            throw new Exception("Value received is not a calendar month");
        } else {
            LocalDateTime today = LocalDateTime.now();

            List<String> allBookingsInMonth = new ArrayList<>();

            for (Booking booking : repository.findAll()) {
                if ( booking.getBookingDate().isAfter(today)
                        && booking.getBookingDate().getMonthValue() == desiredMonth
                        && booking.getBookingDate().getYear() == desiredYear) {
                    String value = booking.getBookingDate().getYear()
                            + "," + booking.getBookingDate().getMonthValue()
                            + "," + booking.getBookingDate().getDayOfMonth();
                    allBookingsInMonth.add(value);
                }
            }

            Set<String> dates = new HashSet<>(allBookingsInMonth); // eliminate duplicates

            HashMap<String, Integer> datesMap = new HashMap<>();

            for (String date : dates) {
                int count = Collections.frequency(allBookingsInMonth, date);
                datesMap.put(date, count);
            }

            System.out.println(datesMap);

            return datesMap;
        }
    }

    public List<LocalDateTime> getAllDatesOnLatestDay() {
        List<Booking> sortedBookings = repository.findAll().stream()
                .sorted(Comparator.comparing(Booking::getBookingDate))
                .toList();

        // will use to check if there are any other dates equal to this day
        LocalDateTime latestDate = sortedBookings.get(sortedBookings.size() - 1).getBookingDate();

        // The desired day
        int desiredYear = latestDate.getYear();
        int desiredMonth = latestDate.getMonthValue();
        int desiredDay = latestDate.getDayOfMonth();

        List<Booking> bookingsOnLatestDay = repository.findAll().stream().filter(date ->
                date.getBookingDate().getYear() == desiredYear &&
                date.getBookingDate().getMonthValue() == desiredMonth &&
                date.getBookingDate().getDayOfMonth() == desiredDay).toList();

        ArrayList<LocalDateTime> dates = new ArrayList<>();

        for (Booking date : bookingsOnLatestDay) {
            dates.add(date.getBookingDate());
        }

        return dates;
    }

    @Override
    public List<Booking> getAll() {
        return repository.findAll();
    }
}
