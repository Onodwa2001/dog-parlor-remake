package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.User;
import za.ac.cput.dogparlor.util.Helper;

public class UserFactory {

    public static User createUser(String username, String password, String role) {
        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password)
                || Helper.isNullOrEmpty(role))
            return null;

        return new User.Builder()
                .setUsername(username)
                .setPassword(password)
                .setRole(role)
                .build();
    }

}
