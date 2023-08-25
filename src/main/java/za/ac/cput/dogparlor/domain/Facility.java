package za.ac.cput.dogparlor.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Facility implements Serializable {

    @Id
    private String streetAddress;
    private String suburb;
    private String city;
    private String zipcode;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Staff> staffList = new ArrayList<>();

    protected Facility() {}

    private Facility(Builder builder) {
        this.streetAddress = builder.streetAddress;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.zipcode = builder.zipcode;
        this.staffList = builder.staffList;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(streetAddress, facility.streetAddress) && Objects.equals(suburb, facility.suburb) && Objects.equals(city, facility.city) && Objects.equals(zipcode, facility.zipcode) && Objects.equals(staffList, facility.staffList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress, suburb, city, zipcode, staffList);
    }

    public static class Builder {

        private String streetAddress;
        private String suburb;
        private String city;
        private String zipcode;
        private List<Staff> staffList = new ArrayList<>();

        public Builder() {}

        public Builder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setZipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Builder setStaffList(List<Staff> staffList) {
            this.staffList = staffList;
            return this;
        }

        public Builder copy(final Facility facility) {
            this.streetAddress = facility.streetAddress;
            this.suburb = facility.suburb;
            this.city = facility.city;
            this.zipcode = facility.zipcode;
            this.staffList = facility.staffList;
            return this;
        }

        public Facility build() { return new Facility(this); }

    }

}
