package za.ac.cput.dogparlor.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.Dog;
import za.ac.cput.dogparlor.factory.DogFactory;
import za.ac.cput.dogparlor.service.impl.DogService;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DogServiceTest {

    private DogService dogService = null;
    private Customer customer;
    private Dog dog = DogFactory.createDog("Simba",customer,"Maltese","Poodle",2,"40 Pounds", "10 Inches");

    @Test
    void a_create() {
        Dog dog1 = dogService.create(dog);
        assertNotNull(dog1);
        System.out.println("Created: " + dog1);
    }

    @Test
    void b_read() {
        Dog dog1 = dogService.read(dog.getDogTag());
        assertNotNull(dog1);
        System.out.println("Read: " + dog1);
    }

    @Test
    void c_update() {
        Dog dog1 = new Dog.Builder().copy(dog)
                .setDogTag("Love")
                .build();
        Dog updated = dogService.update(dog1);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean deleted = dogService.delete(dog.getDogTag());
        assertTrue(deleted);
        System.out.println("Deleted: " + (deleted ? "Yes" : "No"));
    }

    @Test
    void d_getAll() {
        List<Dog> dogs = dogService.getAll();
        assertNotNull(dogs);
        System.out.println("All items: " + dogs);
    }
}
