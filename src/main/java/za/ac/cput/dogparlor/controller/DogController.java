package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Dog;
import za.ac.cput.dogparlor.factory.DogFactory;
import za.ac.cput.dogparlor.service.impl.DogService;

import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping("/create")
    public Dog createDog(@RequestParam Dog dog){
        Dog createdDog = DogFactory.createDog(dog.getDogTag(),dog.getCustomer(),dog.getDogName(), dog.getBreed(),dog.getAge(),dog.getDogSize(),dog.getHairLength());
        return dogService.create(createdDog);
    }

    @PostMapping("/update")
    public Dog updateDog(@RequestBody Dog dog) {
        return dogService.update(dog);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDog(@PathVariable String id) {
        return dogService.delete(id);
    }


    @GetMapping("/getall")
    public List<Dog> getAll() {
        return dogService.getAll();
    }
}
