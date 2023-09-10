package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.GroomService;
import za.ac.cput.dogparlor.repository.GroomServiceRepository;
import za.ac.cput.dogparlor.service.IGroomServiceService;

import java.util.List;

@Service
public class GroomServiceServiceImpl implements IGroomServiceService {

    private final GroomServiceRepository repository;

    @Autowired
    private GroomServiceServiceImpl(GroomServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public GroomService create(GroomService groomService) {
        return repository.save(groomService);
    }

    @Override
    public GroomService read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public GroomService update(GroomService groomService) {
        if (repository.existsById(groomService.getServiceId()))
            return repository.save(groomService);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<GroomService> getAll() {
        return repository.findAll();
    }

}
