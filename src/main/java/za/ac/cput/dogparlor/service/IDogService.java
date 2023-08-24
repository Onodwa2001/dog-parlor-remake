package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Dog;

import java.util.List;

public interface IDogService extends IService<Dog, String> {
    List<Dog> getAll();
}
