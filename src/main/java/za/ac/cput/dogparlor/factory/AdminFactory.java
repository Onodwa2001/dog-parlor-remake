package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Admin;
import za.ac.cput.dogparlor.domain.User;
import za.ac.cput.dogparlor.util.Helper;

public class AdminFactory {

    public static Admin createAdmin(User user, String firstName, String lastName) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)
                || user == null)
            return null;

        String id = Helper.generateID();

        return new Admin.Builder()
                .setId(id)
                .setUser(user)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }

}
