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
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    private String firstName;
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Contact> contacts = new ArrayList<Contact>();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<Address>();

    protected Customer() {}

    private Customer(Builder builder) {
        this.customerID = builder.customerID;
        this.user = builder.user;
//        this.username = builder.username;
//        this.password = builder.password;
        this.addresses = builder.addresses;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contacts = builder.contacts;
    }

    public String getCustomerID() {
        return customerID;
    }
//    public String getUsername() {
//        return username;
//    }
//    public String getPassword() {
//        return password;
//    }


    public User getUser() {
        return user;
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
        return Objects.equals(customerID, customer.customerID) && Objects.equals(user, customer.user)
                && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName)
                && Objects.equals(contacts, customer.contacts) && Objects.equals(addresses, customer.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, user, firstName, lastName, contacts, addresses);
    }

    //    username, password,


    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contacts=" + contacts +
                ", addresses=" + addresses +
                '}';
    }

    public static class Builder {

        private String customerID;
        private User user;
        private String firstName;
        private String lastName;

        private List<Contact> contacts = new ArrayList<Contact>();
        private List<Address> addresses = new ArrayList<Address>();

        public Builder() {}

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        //        public Builder setUsername(String username) {
//            this.username = username;
//            return this;
//        }
//
//        public Builder setPassword(String password) {
//            this.password = password;
//            return this;
//        }

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
            this.user = customer.user;
//            this.username = customer.username;
//            this.password = customer.password;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.contacts = customer.contacts;
            this.addresses = customer.addresses;
            return this;
        }

        public Customer build() { return new Customer(this); }

    }

}
