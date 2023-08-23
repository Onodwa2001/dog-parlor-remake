package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.domain.Feedback;
import za.ac.cput.dogparlor.util.Helper;

import java.time.LocalDateTime;

public class FeedbackFactory {

    public static Feedback createFeedback(String title, String description,
                                          LocalDateTime datePosted, Booking booking) {
        if (Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(description))
            return null;

        String id = Helper.generateID();

        return new Feedback.Builder()
                .setFeedbackID(id)
                .setDescription(description)
                .setDatePosted(datePosted)
                .setBooking(booking)
                .build();
    }

}
