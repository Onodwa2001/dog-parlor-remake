package za.ac.cput.dogparlor.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Staff implements Serializable {

    @Id
    private String staffNumber;
    private String firstName, lastName;
    private String speciality;

    @OneToOne(cascade = CascadeType.ALL)
    private Role role;
    @ManyToMany
    private List<Booking> bookings = new ArrayList<>();

    protected Staff() {}

    private Staff(Builder builder) {
        this.staffNumber = builder.staffNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.role = builder.role;
        this.speciality = builder.speciality;
        this.bookings = builder.bookings;
    }


    public String getStaffNumber() {
        return staffNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public Role getRole() {
        return role;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(staffNumber, staff.staffNumber) && Objects.equals(firstName, staff.firstName) && Objects.equals(lastName, staff.lastName) && Objects.equals(speciality, staff.speciality) && Objects.equals(role, staff.role) && Objects.equals(bookings, staff.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNumber, firstName, lastName, speciality, role, bookings);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffNumber='" + staffNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", role=" + role +
                ", bookings=" + bookings +
                '}';
    }


    public static class Builder {

        private String staffNumber;
        private String firstName, lastName;
        private String speciality;
        private Role role;
        private List<Booking> bookings = new ArrayList<>();

        public Builder() {}

        public Builder setStaffNumber(String staffNumber) {
            this.staffNumber = staffNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setSpeciality(String speciality) {
            this.speciality = speciality;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder setBookings(List<Booking> bookings) {
            this.bookings = bookings;
            return this;
        }

        public Builder copy(final Staff staff) {
            this.staffNumber = staff.staffNumber;
            this.firstName = staff.firstName;
            this.lastName = staff.lastName;
            this.role = staff.role;
            this.speciality = staff.speciality;
            this.bookings = staff.bookings;
            return this;
        }

        public Staff build() { return new Staff(this); }

    }

}
