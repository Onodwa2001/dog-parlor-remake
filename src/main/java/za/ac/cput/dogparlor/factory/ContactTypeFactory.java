package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.ContactType;

public class ContactTypeFactory {

    public static ContactType createContactType(boolean isEmail, boolean isPhone) {

        if (!(isEmail || isPhone)) {
            return null;
        }
        if (isEmail && isPhone) {
            return null;
        }

        return new ContactType.Builder()
                .setEmail(isEmail)
                .setPhone(isPhone)
                .build();

    }

}
