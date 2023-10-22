/* StaffService.java
  Entity for the Staff
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.domain.Role;
import za.ac.cput.dogparlor.domain.Staff;
import za.ac.cput.dogparlor.repository.StaffRepository;
import za.ac.cput.dogparlor.service.IStaffService;

import java.util.List;

@Service
public class StaffService implements IStaffService {

    private final StaffRepository repository;

    @Autowired
    private StaffService(StaffRepository staffRepository){
        this.repository = staffRepository;
    }

    @Override
    public Staff create(Staff staff) {
        return repository.save(staff);
    }

    @Override
    public Staff read(String id) {
        return repository.findById(id).orElse(null);
    }

    public Staff getStaffByUsername(String username) {
        return repository.getStaffByUser_Username(username).orElse(null);
    }

    @Override
    public Staff update(Staff staff) {
        if (repository.existsById(staff.getStaffNumber()))
            return repository.save(staff);
        return null;

    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;

        }
        return false;
    }

    public void deleteRoleFromStaff(String staffNumber) {
        // Retrieve the customer entity
        Staff optionalStaff = repository.findById(staffNumber).orElse(null);

        if (optionalStaff != null) {

            // Retrieve the contact list from the customer
            List<Role> roles = optionalStaff.getRole();


            if (roles != null) {
                // Remove the contact from the list
                roles.clear();

                // Update the customer entity
                Staff newStaff = new Staff.Builder().copy(optionalStaff).setRole(roles).build();
                repository.save(newStaff);
            } else {
                // Handle case when contact is not found
                // Perhaps throw an exception or handle accordingly
            }
        } else {
            // Handle case when customer is not found
            // Perhaps throw an exception or handle accordingly
        }
    }

    @Override
    public List<Staff> getAll() {
        return repository.findAll();
    }
}
