package za.ac.cput.dogparlor.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Contact implements Serializable {

    @Id
    private String contactValue;

    @Embedded
    private ContactType contactType;

    protected Contact() {}

    private Contact(Builder builder) {
        this.contactValue = builder.contactValue;
        this.contactType = builder.contactType;
    }


    public String getContactValue() {
        return contactValue;
    }

    public ContactType getContactType() {
        return contactType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactValue, contact.contactValue) && Objects.equals(contactType, contact.contactType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactValue, contactType);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactValue='" + contactValue + '\'' +
                ", contactType=" + contactType +
                '}';
    }

    public static class Builder {

        private String contactValue;
        private ContactType contactType;

        public Builder() {}

        public Builder setContactValue(String contactValue) {
            this.contactValue = contactValue;
            return this;
        }

        public Builder setContactType(ContactType contactType) {
            this.contactType = contactType;
            return this;
        }

        public Builder copy(Contact contact) {
            this.contactValue = contact.contactValue;
            this.contactType = contact.contactType;
            return this;
        }

        public Contact build() { return new Contact(this); }
    }

}
