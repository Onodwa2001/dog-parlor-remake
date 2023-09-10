/* StaffService.java
  Entity for the Staff
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public List<Staff> getAll() {
        return repository.findAll();
    }
}
