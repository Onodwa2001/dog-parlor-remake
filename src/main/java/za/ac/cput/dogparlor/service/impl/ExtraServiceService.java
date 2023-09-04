package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.ExtraService;
import za.ac.cput.dogparlor.repository.ExtraServiceRepository;
import za.ac.cput.dogparlor.service.IExtraServiceService;

import java.util.List;

@Service
public class ExtraServiceService implements IExtraServiceService {

    private final ExtraServiceRepository repository;

    @Autowired
    public ExtraServiceService(ExtraServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExtraService create(ExtraService extraService) {
        return repository.save(extraService);
    }

    @Override
    public ExtraService read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ExtraService update(ExtraService extraService) {
        if (repository.existsById(extraService.getExtraServiceId()))
            return repository.save(extraService);
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
    public List<ExtraService> getAllExtraServices() {
        return repository.findAll();
    }

}
