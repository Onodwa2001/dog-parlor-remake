package za.ac.cput.dogparlor.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContactType implements Serializable {

    private boolean isEmail, isPhone;

    protected ContactType() {}

    private ContactType(Builder builder) {
        this.isEmail = builder.isEmail;
        this.isPhone = builder.isPhone;
    }


    public boolean isEmail() {
        return isEmail;
    }

    public boolean isPhone() {
        return isPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactType that = (ContactType) o;
        return isEmail == that.isEmail && isPhone == that.isPhone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isEmail, isPhone);
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "isEmail=" + isEmail +
                ", isPhone=" + isPhone +
                '}';
    }

    public static class Builder {

        private boolean isEmail, isPhone;

        public Builder() {}

        public Builder setEmail(boolean email) {
            isEmail = email;
            return this;
        }

        public Builder setPhone(boolean phone) {
            isPhone = phone;
            return this;
        }

        public Builder copy(ContactType contactType) {
            this.isEmail = contactType.isEmail;
            this.isPhone = contactType.isPhone;
            return this;
        }

        public ContactType build() { return new ContactType(this); }
    }

}
