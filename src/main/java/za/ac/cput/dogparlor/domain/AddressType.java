package za.ac.cput.dogparlor.domain;

        import jakarta.persistence.Embeddable;

        import java.io.Serializable;
        import java.util.Objects;

@Embeddable
public class AddressType implements Serializable {

    private boolean isApartment, isHome, isComplex, isDuplex;

    protected AddressType() {}

    private AddressType(Builder builder) {
        this.isApartment = builder.isApartment;
        this.isHome = builder.isHome;
        this.isComplex = builder.isComplex;
        this.isDuplex = builder.isDuplex;
    }


    public boolean isApartment() {
        return isApartment;
    }

    public boolean isHome() {
        return isHome;
    }

    public boolean isComplex() {
        return isComplex;
    }

    public boolean isDuplex() {
        return isDuplex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressType that = (AddressType) o;
        return isApartment == that.isApartment && isHome == that.isHome && isComplex == that.isComplex && isDuplex == that.isDuplex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isApartment, isHome, isComplex, isDuplex);
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "isApartment=" + isApartment +
                ", isHome=" + isHome +
                ", isComplex=" + isComplex +
                ", isDuplex=" + isDuplex +
                '}';
    }

    public static class Builder {

        private boolean isApartment, isHome, isComplex, isDuplex;

        public Builder() {}

        public Builder setApartment(boolean apartment) {
            isApartment = apartment;
            return this;
        }

        public Builder setHome(boolean home) {
            isHome = home;
            return this;
        }

        public Builder setComplex(boolean complex) {
            isComplex = complex;
            return this;
        }

        public Builder setDuplex(boolean duplex) {
            isDuplex = duplex;
            return this;
        }

        public Builder copy(AddressType addressType) {
            this.isApartment = addressType.isApartment;
            this.isHome = addressType.isHome();
            this.isComplex = addressType.isComplex();
            this.isDuplex = addressType.isDuplex();
            return this;
        }

        public AddressType build() { return new AddressType(this); }

    }

}