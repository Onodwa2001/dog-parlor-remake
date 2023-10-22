package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.dogparlor.domain.Admin;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.Staff;
import za.ac.cput.dogparlor.dto.AuthRequest;
import za.ac.cput.dogparlor.service.impl.AdminService;
import za.ac.cput.dogparlor.service.impl.CustomerService;
import za.ac.cput.dogparlor.service.impl.JwtService;
import za.ac.cput.dogparlor.service.impl.StaffService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            Customer customer = customerService.getCustomerByUsername(authRequest.getUsername());
            Staff staff = staffService.getStaffByUsername(authRequest.getUsername());
            Admin admin = adminService.getAdminByUsername(authRequest.getUsername());
            return jwtService.generateToken(authRequest.getUsername(), customer, staff, admin);
        } else {
            throw new UsernameNotFoundException("invalid user request");
        }
    }

}

