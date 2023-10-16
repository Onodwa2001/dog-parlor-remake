package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.Dog;
import za.ac.cput.dogparlor.util.Helper;

public class DogFactory {

    public static Dog createDog(String dogTag, Customer customer, String dogName,
                                String breed, int age, String dogSize, String hairLength) {

        if (Helper.isNullOrEmpty(dogName) || Helper.isNullOrEmpty(breed)
                || Helper.isNullOrEmpty(dogSize) || Helper.isNullOrEmpty(hairLength))
            return null;

        if (age < 0)
            return null;

        return new Dog.Builder()
                .setDogTag(dogTag)
                .setCustomerID(customer)
                .setDogName(dogName)
                .setBreed(breed)
                .setAge(age)
                .setDogSize(dogSize)
                .setHairLength(hairLength)
                .build();
    }

}
