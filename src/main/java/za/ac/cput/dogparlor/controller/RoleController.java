package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/create")
    public Role createRole(@RequestParam Role role){
        Role create = RoleFactory.createRole(role.getName());
        return service.create(create);
    }

    @GetMapping("/read/{id}")
    public Role read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Role update(@RequestBody Role role){
        return service.update(role);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/getall")
    public List<Role> getAll(){
        return service.getAll();
    }
}
