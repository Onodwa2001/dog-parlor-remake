package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Contact;
import za.ac.cput.dogparlor.domain.ContactType;
import za.ac.cput.dogparlor.util.Helper;

public class ContactFactory {

    public static Contact createContact(String contactValue, ContactType contactType) {

        if (!Helper.isNullOrEmpty(contactValue))
            return null;

        if (contactType.isEmail()) {
            System.out.println("It's an email");
            if (!Helper.isValidEmail(contactValue))
                return null;
        } else if (contactType.isPhone()) {
            System.out.println("It's a phone");
            if (!Helper.isNumeric(contactValue))
                return null;
        }

        return new Contact.Builder()
                .setContactValue(contactValue)
                .setContactType(contactType)
                .build();

    }

}
