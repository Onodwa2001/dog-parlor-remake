package za.ac.cput.dogparlor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.dogparlor.domain.Admin;
import za.ac.cput.dogparlor.repository.AdminRepository;
import za.ac.cput.dogparlor.service.IAdminService;

@Service
public class AdminService implements IAdminService<Admin, String> {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

}
