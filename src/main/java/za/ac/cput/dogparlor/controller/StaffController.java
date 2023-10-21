
/* StaffController.java
  Entity for the Staff
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Role;
import za.ac.cput.dogparlor.domain.Staff;
import za.ac.cput.dogparlor.domain.User;
import za.ac.cput.dogparlor.factory.RoleFactory;
import za.ac.cput.dogparlor.factory.StaffFactory;
import za.ac.cput.dogparlor.factory.UserFactory;
import za.ac.cput.dogparlor.service.impl.StaffService;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private PasswordEncoder encoder;

    // admin
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Staff createStaff(@RequestBody Staff staff){
        String encodedPassword = encoder.encode(staff.getUser().getPassword());
        User user = UserFactory.createUser(staff.getUser().getUsername(), encodedPassword, staff.getUser().getRole());

        System.out.println(user);
        Staff createdStaff = StaffFactory.createStaff(user, staff.getFirstName(),staff.getLastName(),
                staff.getSpeciality(),staff.getRole());
        return staffService.create(createdStaff);
    }

    // admin
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Staff updateStaff(@RequestBody Staff staff) {
        return staffService.update(staff);
    }

    // admin
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public boolean deleteStaff(@PathVariable String id) {
        return staffService.delete(id);
    }

    // admin
    @GetMapping("/getall")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Staff> getAll() {
        return staffService.getAll();
    }
}
