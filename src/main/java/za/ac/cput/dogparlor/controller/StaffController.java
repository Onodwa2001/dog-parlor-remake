package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Staff;
import za.ac.cput.dogparlor.factory.StaffFactory;
import za.ac.cput.dogparlor.service.impl.StaffService;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/create")
    public Staff createStaff(@RequestParam Staff staff){
        Staff createdStaff = StaffFactory.createStaff(staff.getFirstName(),staff.getLastName(),staff.getSpeciality(),staff.getRole(),staff.getBookings());
        return staffService.create(createdStaff) ;

    }

    @PostMapping("/update")
    public Staff updateStaff(@RequestBody Staff staff) {
        return staffService.update(staff);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteStaff(@PathVariable String id) {
        return staffService.delete(id);
    }


    @GetMapping("/getall")
    public List<Staff> getAll() {
        return staffService.getAll();
    }
}
