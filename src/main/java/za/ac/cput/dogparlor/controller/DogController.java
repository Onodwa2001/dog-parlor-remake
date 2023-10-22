/* DogController.java
  Entity for the Dog
  Author: Byron Young (218155077)
  Date:27 August 2023
 */

package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.Dog;
import za.ac.cput.dogparlor.factory.CustomerFactory;
import za.ac.cput.dogparlor.factory.DogFactory;
import za.ac.cput.dogparlor.service.impl.DogService;

import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    // customer
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('USER')")
    public Dog createDog(@RequestBody Dog dog){
        System.out.println(dog.getCustomer());

        Dog createdDog = DogFactory.createDog(dog.getDogTag(),dog.getCustomer(),dog.getDogName(),
                dog.getBreed(),dog.getAge(),dog.getDogSize(),dog.getHairLength());
        return dogService.create(createdDog);
    }

    // customer
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('USER')")
    public Dog updateDog(@RequestBody Dog dog) {
        return dogService.update(dog);
    }

    // customer
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public boolean deleteDog(@PathVariable String id) {
        return dogService.delete(id);
    }

    // customer
    @PostMapping("/getall-by-customer")
    @PreAuthorize("hasAuthority('USER')")
    public List<Dog> getAllByCustomerId(@RequestBody Customer customer) {
        return dogService.getAllByCustomer(customer);
    }

    // customer
    @GetMapping("/getall")
    @PreAuthorize("hasAuthority('USER')")
    public List<Dog> getAll() {
        return dogService.getAll();
    }
}
