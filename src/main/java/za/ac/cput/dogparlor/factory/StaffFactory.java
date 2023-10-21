package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.domain.Role;
import za.ac.cput.dogparlor.domain.Staff;
import za.ac.cput.dogparlor.domain.User;
import za.ac.cput.dogparlor.util.Helper;

import java.util.List;

public class StaffFactory {

    public static Staff createStaff(User user, String firstName, String lastName,
                                    String specialty, List<Role> role) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(specialty) || user == null)
            return null;

        if (role == null)
            return null;

        String staffNumber = Helper.getStaffNumber();

        return new Staff.Builder()
                .setStaffNumber(staffNumber)
                .setUser(user)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setSpeciality(specialty)
                .setRole(role)
                .build();
    }

}
