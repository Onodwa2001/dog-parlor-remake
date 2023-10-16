/* Dog.java
  Entity for the Dog
  Author: Byron Young (218155077)
  Date:27 August 2023
 */

package za.ac.cput.dogparlor.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Dog implements Serializable {

    @Id
    private String dogTag;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    private String dogName;
    private String breed;
    private int age;
    private String dogSize;
    private String hairLength;

    protected Dog() {}

    private Dog(Builder builder) {
        this.dogTag = builder.dogTag;
        this.dogName = builder.dogName;
        this.customer = builder.customer;
        this.breed = builder.breed;
        this.age = builder.age;
        this.dogSize = builder.dogSize;
        this.hairLength = builder.hairLength;
    }


    public String getDogTag() {
        return dogTag;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getDogName() {
        return dogName;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getDogSize() {
        return dogSize;
    }

    public String getHairLength() {
        return hairLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(dogTag, dog.dogTag) && Objects.equals(customer, dog.customer) && Objects.equals(dogName, dog.dogName) && Objects.equals(breed, dog.breed) && Objects.equals(dogSize, dog.dogSize) && Objects.equals(hairLength, dog.hairLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogTag, customer, dogName, breed, age, dogSize, hairLength);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogTag='" + dogTag + '\'' +
                ", customer=" + customer +
                ", dogName='" + dogName + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", dogSize='" + dogSize + '\'' +
                ", hairLength='" + hairLength + '\'' +
                '}';
    }

    public static class Builder {

        private String dogTag;
        private Customer customer;
        private String dogName;
        private String breed;
        private int age;
        private String dogSize;
        private String hairLength;

        public Builder() {}

        public Builder setDogTag(String dogTag) {
            this.dogTag = dogTag;
            return this;
        }

        public Builder setCustomerID(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setDogName(String dogName) {
            this.dogName = dogName;
            return this;
        }

        public Builder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setDogSize(String dogSize) {
            this.dogSize = dogSize;
            return this;
        }

        public Builder setHairLength(String hairLength) {
            this.hairLength = hairLength;
            return this;
        }

        public Builder copy(Dog dog) {
            this.dogTag = dog.dogTag;
            this.dogName = dog.dogName;
            this.customer = dog.customer;
            this.age = dog.age;
            this.breed = dog.breed;
            this.dogSize = dog.dogSize;
            this.hairLength = dog.hairLength;
            return this;
        }

        public Dog build() { return new Dog(this); }

    }

}
