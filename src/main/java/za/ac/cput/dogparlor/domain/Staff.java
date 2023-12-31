/* Staff.java
  Entity for the Staff
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
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
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    private String firstName, lastName;
    private String speciality;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Role> role = new ArrayList<>();

    protected Staff() {}

    private Staff(Builder builder) {
        this.staffNumber = builder.staffNumber;
        this.user = builder.user;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.role = builder.role;
        this.speciality = builder.speciality;
    }


    public String getStaffNumber() {
        return staffNumber;
    }

    public User getUser() {
        return user;
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

    public List<Role> getRole() {
        return role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(staffNumber, staff.staffNumber) && Objects.equals(user, staff.user) && Objects.equals(firstName, staff.firstName) && Objects.equals(lastName, staff.lastName) && Objects.equals(speciality, staff.speciality) && Objects.equals(role, staff.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffNumber, user, firstName, lastName, speciality, role);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffNumber='" + staffNumber + '\'' +
                ", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", role=" + role +
                '}';
    }

    public static class Builder {

        private String staffNumber;
        private User user;
        private String firstName, lastName;
        private String speciality;
        private List<Role> role;

        public Builder() {}

        public Builder setStaffNumber(String staffNumber) {
            this.staffNumber = staffNumber;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
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

        public Builder setRole(List<Role> role) {
            this.role = role;
            return this;
        }


        public Builder copy(final Staff staff) {
            this.staffNumber = staff.staffNumber;
            this.user = staff.user;
            this.firstName = staff.firstName;
            this.lastName = staff.lastName;
            this.role = staff.role;
            this.speciality = staff.speciality;
            return this;
        }

        public Staff build() { return new Staff(this); }

    }

}
