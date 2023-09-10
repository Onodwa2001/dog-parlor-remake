/* DogService.java
  Entity for the Dog
  Author: Byron Young (218155077)
  Date:27 August 2023
 */

package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Dog;
import za.ac.cput.dogparlor.repository.DogRepository;
import za.ac.cput.dogparlor.service.IDogService;

import java.util.List;

@Service
public class DogService implements IDogService {

    private final DogRepository repository;

    @Autowired
    private DogService(DogRepository dogRepository){this.repository = dogRepository;}

    @Override
    public Dog create(Dog dog) {
        return repository.save(dog);
    }

    @Override
    public Dog read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Dog update(Dog dog) {
        if (repository.existsById(dog.getDogTag()))
            return repository.save(dog);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;

        }
        return false;
    }

    @Override
    public List<Dog> getAll() {
        return repository.findAll();
    }
}
