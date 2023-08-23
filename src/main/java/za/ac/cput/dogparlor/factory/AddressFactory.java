package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.Address;
import za.ac.cput.dogparlor.domain.AddressType;
import za.ac.cput.dogparlor.util.Helper;

public class AddressFactory {

    public static Address createAddress(String addressValue, AddressType addressType,
                                        String suburb, String zipcode, String city) {
        if (Helper.isNullOrEmpty(addressValue) || Helper.isNullOrEmpty(suburb)
                || Helper.isNullOrEmpty(zipcode) || Helper.isNullOrEmpty(city))
            return null;

        return new Address.Builder()
                .setAddressValue(addressValue)
                .setAddressType(addressType)
                .setSuburb(suburb)
                .setZipcode(zipcode)
                .setCity(city)
                .build();
    }

}
