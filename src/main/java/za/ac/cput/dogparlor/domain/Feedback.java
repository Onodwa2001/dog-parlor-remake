package za.ac.cput.dogparlor.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Feedback implements Serializable {

    @Id
    private String feedbackID;
    private String title;
    private String description;
    private LocalDateTime datePosted;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Booking booking;

    protected Feedback() {}

    private Feedback(Builder builder) {
        this.feedbackID = builder.feedbackID;
        this.title = builder.title;
        this.description = builder.description;
        this.datePosted = builder.datePosted;
        this.booking = builder.booking;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(feedbackID, feedback.feedbackID) && Objects.equals(title, feedback.title) && Objects.equals(description, feedback.description) && Objects.equals(datePosted, feedback.datePosted) && Objects.equals(booking, feedback.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackID, title, description, datePosted, booking);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackID='" + feedbackID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", datePosted=" + datePosted +
                ", booking=" + booking +
                '}';
    }

    public static class Builder {

        private String feedbackID;
        private String title;
        private String description;
        private LocalDateTime datePosted;
        private Booking booking;

        public Builder() {}

        public Builder setFeedbackID(String feedbackID) {
            this.feedbackID = feedbackID;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDatePosted(LocalDateTime datePosted) {
            this.datePosted = datePosted;
            return this;
        }

        public Builder setBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Builder copy(Feedback feedback) {
            this.feedbackID = feedback.feedbackID;
            this.title = feedback.title;
            this.description = feedback.description;
            this.datePosted = feedback.datePosted;
            this.booking = feedback.booking;
            return this;
        }

        public Feedback build() { return new Feedback(this); }

    }

}
