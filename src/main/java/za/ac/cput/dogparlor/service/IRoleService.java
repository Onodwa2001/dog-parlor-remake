package za.ac.cput.dogparlor.service;




import za.ac.cput.dogparlor.domain.Role;

import java.util.List;

public interface IRoleService extends IService<Role, String>{

    List<Role> getAll();
}
