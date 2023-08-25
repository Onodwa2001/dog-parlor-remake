package za.ac.cput.dogparlor.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class ExtraService implements Serializable {

    @Id
    private String extraServiceId;
    private String extraServiceName;
    private double price;

    protected ExtraService() {}

    private ExtraService(Builder builder) {
        this.extraServiceId = builder.extraServiceId;
        this.extraServiceName = builder.extraServiceName;
        this.price = builder.price;
    }

    public String getExtraServiceId() {
        return extraServiceId;
    }

    public String getExtraServiceName() {
        return extraServiceName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraService that = (ExtraService) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(extraServiceId, that.extraServiceId)
                && Objects.equals(extraServiceName, that.extraServiceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extraServiceId, extraServiceName, price);
    }

    @Override
    public String toString() {
        return "ExtraService{" +
                "extraServiceId='" + extraServiceId + '\'' +
                ", extraServiceName='" + extraServiceName + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder {

        private String extraServiceId;
        private String extraServiceName;
        private double price;

        public Builder() {}

        public Builder setExtraServiceId(String extraServiceId) {
            this.extraServiceId = extraServiceId;
            return this;
        }

        public Builder setExtraServiceName(String extraServiceName) {
            this.extraServiceName = extraServiceName;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(final ExtraService extraService) {
            this.extraServiceId = extraService.extraServiceId;
            this.extraServiceName = extraService.extraServiceName;
            this.price = extraService.price;
            return this;
        }

        public ExtraService build() { return new ExtraService(this); }

    }

}
