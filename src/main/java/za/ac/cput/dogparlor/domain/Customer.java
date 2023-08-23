package za.ac.cput.dogparlor.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer implements Serializable {

    @Id
    private String customerID;
    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<Contact>();

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Contact> getContacts() {
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

    public static class Builder {

        private String customerID;
        private String firstName;
        private String lastName;

        private List<Contact> contacts = new ArrayList<Contact>();
        private List<Address> addresses = new ArrayList<Address>();

        public Builder() {}

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
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

        public Builder setContacts(List<Contact> contacts) {
            this.contacts = contacts;
            return this;
        }

        public Builder setAddresses(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Builder copy(Customer customer) {
            this.customerID = customer.customerID;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.contacts = customer.contacts;
            this.addresses = customer.addresses;
            return this;
        }

        public Customer build() { return new Customer(this); }

    }

}
