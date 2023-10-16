/* Booking.java
  Entity for the Booking
  Author: Byron Young (218155077)
  Date:27 August 2023
 */

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

    private LocalDateTime bookingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Dog dog;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Staff> staffList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<GroomService> groomServices = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ExtraService> extraServices = new ArrayList<>();

    private double total;

    protected Booking() {}

    private Booking(Builder builder) {
        this.bookingID = builder.bookingID;
        this.bookingDate = builder.bookingDate;
        this.dog = builder.dog;
        this.staffList = builder.staffList;
        this.groomServices = builder.groomServices;
        this.extraServices = builder.extraServices;
        this.total = builder.total;
    }

    public String getBookingID() {
        return bookingID;
    }


    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public Dog getDog() {
        return dog;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public List<GroomService> getGroomServices() {
        return groomServices;
    }

    public List<ExtraService> getExtraServices() {
        return extraServices;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Double.compare(total, booking.total) == 0 && Objects.equals(bookingID, booking.bookingID) && Objects.equals(bookingDate, booking.bookingDate) && Objects.equals(dog, booking.dog) && Objects.equals(staffList, booking.staffList) && Objects.equals(groomServices, booking.groomServices) && Objects.equals(extraServices, booking.extraServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, bookingDate, dog, staffList, groomServices, extraServices, total);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", bookingDate=" + bookingDate +
                ", dog=" + dog +
                ", staffList=" + staffList +
                ", groomServices=" + groomServices +
                ", extraServices=" + extraServices +
                ", total=" + total +
                '}';
    }

    public static class Builder {

        private String bookingID;
        private LocalDateTime bookingDate;
        private Dog dog;
        private List<Staff> staffList = new ArrayList<>();
        private List<GroomService> groomServices = new ArrayList<>();
        private List<ExtraService> extraServices = new ArrayList<>();
        private double total;

        public Builder() {}

        public Builder setBookingID(String bookingID) {
            this.bookingID = bookingID;
            return this;
        }

        public Builder setBookingDate(LocalDateTime bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder setDog(Dog dog) {
            this.dog = dog;
            return this;
        }

        public Builder setStaffList(List<Staff> staffList) {
            this.staffList = staffList;
            return this;
        }

        public Builder setGroomServices(List<GroomService> groomServices) {
            this.groomServices = groomServices;
            return this;
        }

        public Builder setExtraServices(List<ExtraService> extraServices) {
            this.extraServices = extraServices;
            return this;
        }

        public Builder setTotal(double total) {
            this.total = total;
            return this;
        }

        public Builder copy(Booking booking) {
            this.bookingID = booking.bookingID;
            this.bookingDate = booking.bookingDate;
            this.dog = booking.dog;
            this.staffList = booking.staffList;
            this.groomServices = booking.groomServices;
            this.extraServices = booking.extraServices;
            this.total = booking.total;
            return this;
        }

        public Booking build() { return new Booking(this); }

    }

}
