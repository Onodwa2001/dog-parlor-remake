package za.ac.cput.dogparlor.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer implements Serializable {

    @Id
    private List<Address> customerID;
    private List<Address> firstName;
    private List<Address> lastName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> contacts = new ArrayList<Address>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<Address>();

    protected Customer() {}

    private Customer(Builder builder) {
        this.customerID = builder.customerID;
        this.addresses = builder.addresses;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contacts = builder.contacts;
    }

    public String getCustomerID() {
        return customerID;
    }

    public List<Address> getFirstName() {
        return firstName;
    }

    public List<Address> getLastName() {
        return lastName;
    }

    public List<Address> getContacts() {
        return contacts;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerID, customer.customerID) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(contacts, customer.contacts) && Objects.equals(addresses, customer.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, firstName, lastName, contacts, addresses);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contacts=" + contacts +
                ", addresses=" + addresses +
                '}';
    }

    public int create(Customer customer) {

        return 0;
    }

    public static class Builder {

        private List<Address> customerID;
        private List<Address> firstName;
        private List<Address> lastName;

        private List<Address> contacts = new ArrayList<Address>();
        private List<Address> addresses = new ArrayList<Address>();

        public Builder() {}

        public Builder setCustomerID(List<Address> customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setFirstName(List<Address> firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(List<Address> lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContacts(List<Address> contacts) {
            this.contacts = contacts;
            return this;
        }

        public Builder setAddresses(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Builder copy(List<Address> customer) {
            this.customerID = customer;
            this.firstName = customer;
            this.lastName = customer;
            this.contacts = customer;
            this.addresses = customer;
            return this;
        }

        public Customer build() { return new Customer(this); }

    }

}
