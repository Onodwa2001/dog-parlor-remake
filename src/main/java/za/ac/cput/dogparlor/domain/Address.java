package za.ac.cput.dogparlor.domain;

        import jakarta.persistence.*;

        import java.io.Serializable;
        import java.util.Objects;

@Entity
public class Address implements Serializable {

    @Id
    private String addressValue;

    @Embedded
    private AddressType addressType;

    private String suburb;
    private String zipcode;
    private String city;

    protected Address() {}

    private Address(Builder builder) {
        this.addressType = builder.addressType;
        this.addressValue = builder.addressValue;
        this.suburb = builder.suburb;
        this.zipcode = builder.zipcode;
        this.city = builder.city;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public String getAddressValue() {
        return addressValue;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(addressValue, address.addressValue) && Objects.equals(addressType, address.addressType)
                && Objects.equals(suburb, address.suburb) && Objects.equals(zipcode, address.zipcode)
                && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressValue, addressType, suburb, zipcode, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressValue='" + addressValue + '\'' +
                ", addressType=" + addressType +
                ", suburb='" + suburb + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static class Builder {

        private AddressType addressType;
        private String addressValue;
        private String suburb;
        private String zipcode;
        private String city;

        public Builder() {}

        public Builder setAddressType(AddressType addressType) {
            this.addressType = addressType;
            return this;
        }

        public Builder setAddressValue(String addressValue) {
            this.addressValue = addressValue;
            return this;
        }

        public Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder setZipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder copy(Address address) {
            this.addressType = address.addressType;
            this.addressValue = address.addressValue;
            this.suburb = address.suburb;
            this.zipcode = address.zipcode;
            this.city = address.city;
            return this;
        }

        public Address build() { return new Address(this); }

    }

}