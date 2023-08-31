package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Role;
import za.ac.cput.dogparlor.repository.RoleRepository;
import za.ac.cput.dogparlor.service.IRoleService;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    private final RoleRepository repo;

    @Autowired
    private RoleService(RoleRepository  repo){
        this.repo = repo;
    }

    @Override
    public Role create(Role role) {
        return repo.save(role);
    }

    @Override
    public Role read(String id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public Role update(Role role) {
        if (repo.existsById(role.getRoleID()))
            return  repo.save(role);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Role> getAll() {
        return repo.findAll();
    }
}

