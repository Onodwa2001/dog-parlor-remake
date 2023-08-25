package za.ac.cput.dogparlor.service;

import za.ac.cput.dogparlor.domain.Staff;

import java.util.List;

public interface IStaffService extends IService<Staff, String> {
    List<Staff> getAll();
}
