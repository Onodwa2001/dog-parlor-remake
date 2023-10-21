package za.ac.cput.dogparlor.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Admin implements Serializable {

    @Id
    private String id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    private String firstName;
    private String lastName;

    protected Admin() {}

    private Admin(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) && Objects.equals(user, admin.user) && Objects.equals(firstName, admin.firstName) && Objects.equals(lastName, admin.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {

        private String id, firstName, lastName;
        private User user;

        public Builder() {

        }

        public Builder setId(String id) {
            this.id = id;
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

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Admin admin) {
            this.id = admin.id;
            this.user = admin.user;
            this.firstName = admin.firstName;
            this.lastName = admin.lastName;
            return this;
        }

        public Admin build() { return new Admin(this); }

    }

}
