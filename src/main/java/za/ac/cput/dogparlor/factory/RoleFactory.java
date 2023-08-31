package za.ac.cput.dogparlor.factory;


import za.ac.cput.dogparlor.domain.Role;
import za.ac.cput.dogparlor.util.Helper;

public class RoleFactory {

    public static Role createRole(String name){

        if(Helper.isNullOrEmpty(name))
            return null;

        String roleID = Helper.generateID();

        return new Role.Builder()
                   .setRoleID(roleID)
                   .setName(name)
                   .build();
    }
}
