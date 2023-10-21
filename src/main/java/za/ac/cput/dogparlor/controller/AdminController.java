package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.dogparlor.domain.Admin;
import za.ac.cput.dogparlor.domain.User;
import za.ac.cput.dogparlor.factory.AdminFactory;
import za.ac.cput.dogparlor.factory.UserFactory;
import za.ac.cput.dogparlor.service.impl.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public Admin create(@RequestBody Admin admin) {
        String encodedPassword = passwordEncoder.encode(admin.getUser().getPassword());
        User user = UserFactory.createUser(admin.getUser().getUsername(), encodedPassword, admin.getUser().getRole());

        Admin admin1 = AdminFactory.createAdmin(user, admin.getFirstName(), admin.getLastName());
        return adminService.create(admin1);
    }

}
