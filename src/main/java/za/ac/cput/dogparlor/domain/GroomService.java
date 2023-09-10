/*Service.java
  Entity for the Service
  Author: Karabo Magagula (220042292)
  Date: 04 April 2023
 */
package za.ac.cput.dogparlor.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class GroomService implements Serializable {

    @Id
    private String serviceId;
    private String name;
    private String description;
    private String serviceDuration;
    private double price;
    private String image;

    protected GroomService() {}

    private GroomService(Builder builder) {
        this.serviceId = builder.serviceId;
        this.name = builder.name;
        this.description = builder.description;
        this.serviceDuration = builder.serviceDuration;
        this.price = builder.price;
        this.image = builder.image;
    }

    public String getServiceId() {
        return serviceId;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public String getServiceDuration() {
        return serviceDuration;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroomService that = (GroomService) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(serviceId, that.serviceId) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(serviceDuration, that.serviceDuration) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, name, description, serviceDuration, price, image);
    }

    @Override
    public String toString() {
        return "GroomService{" +
                "serviceId='" + serviceId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", serviceDuration='" + serviceDuration + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }

    public static class Builder{
        private String serviceId;
        private String name;
        private String description;
        private String serviceDuration;
        private double price;
        private String image;

        public Builder() {}
        public Builder setServiceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setServiceDuration(String serviceDuration) {
            this.serviceDuration = serviceDuration;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Builder copy(final GroomService groomService) {
            this.serviceId = groomService.serviceId;
            this.name = groomService.name;
            this.price = groomService.price;
            this.serviceDuration = groomService.serviceDuration;
            this.description = groomService.description;
            this.image = groomService.image;
            return this;
        }

        public GroomService build() {
            return new GroomService(this);
        }

    }


}
