package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Role;
import za.ac.cput.dogparlor.factory.RoleFactory;
import za.ac.cput.dogparlor.service.impl.RoleService;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    // admin
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Role createRole(@RequestBody Role role){
        Role create = RoleFactory.createRole(role.getName());
        return service.create(create);
    }

    // admin and customers
    @GetMapping("/read/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STAFF')")
    public Role read(@PathVariable String id){
        return service.read(id);
    }


    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Role update(@RequestBody Role role){
        return service.update(role);
    }

    // admin
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    // admin
    @GetMapping("/getall")
    public List<Role> getAll(){
        return service.getAll();
    }
}

