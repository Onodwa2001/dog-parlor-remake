package za.ac.cput.dogparlor.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Booking implements Serializable {

    @Id
    private String bookingID;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Staff> staff = new ArrayList<Staff>();
    private LocalDateTime bookingDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<GroomService> groomServices = new ArrayList<GroomService>();
    private double total;

    protected Booking() {}

    private Booking(Builder builder) {
        this.bookingID = builder.bookingID;
        this.staff = builder.staff;
        this.bookingDate = builder.bookingDate;
        this.groomServices = builder.groomServices;
        this.total = builder.total;
    }

    public String getBookingID() {
        return bookingID;
    }

    public List<Staff> getStaffID() {
        return staff;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public List<GroomService> getServices() {
        return groomServices;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Double.compare(booking.total, total) == 0 && Objects.equals(bookingID, booking.bookingID)
                && Objects.equals(staff, booking.staff) && Objects.equals(bookingDate, booking.bookingDate)
                && Objects.equals(groomServices, booking.groomServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, staff, bookingDate, groomServices, total);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", staff=" + staff +
                ", bookingDate=" + bookingDate +
                ", services=" + groomServices +
                ", total=" + total +
                '}';
    }

    public static class Builder {

        private String bookingID;
        private List<Staff> staff;
        private LocalDateTime bookingDate;
        private List<GroomService> groomServices;
        private double total;

        public Builder() {}

        public Builder setBookingID(String bookingID) {
            this.bookingID = bookingID;
            return this;
        }

        public Builder setStaff(List<Staff> staff) {
            this.staff = staff;
            return this;
        }

        public Builder setBookingDate(LocalDateTime bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder setServices(List<GroomService> groomServices) {
            this.groomServices = groomServices;
            return this;
        }

        public Builder setTotal(double total) {
            this.total = total;
            return this;
        }

        public Builder copy(Booking booking) {
            this.bookingID = booking.bookingID;
            this.staff = booking.staff;
            this.bookingDate = booking.bookingDate;
            this.groomServices = booking.groomServices;
            this.total = booking.total;
            return this;
        }

        public Booking build() { return new Booking(this); }

    }

}
