package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.AddressType;

public class AddressTypeFactory {

    public static AddressType createAddressType(boolean isApartment, boolean isHome,
                                                boolean isComplex, boolean isDuplex) {
        if (isApartment && (isHome || isComplex || isDuplex)) {
            return null;
        } else if (isHome && (isComplex || isDuplex)) {
            return null;
        } else if (isComplex && isDuplex) {
            return null;
        }

        return new AddressType.Builder()
                .setApartment(isApartment)
                .setHome(isHome)
                .setComplex(isComplex)
                .setDuplex(isDuplex)
                .build();
    }

}
