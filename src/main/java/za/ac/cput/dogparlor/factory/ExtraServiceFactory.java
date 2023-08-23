package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.ExtraService;
import za.ac.cput.dogparlor.util.Helper;

public class ExtraServiceFactory {

    public static ExtraService createExtraService(String extraServiceName, double price) {
        if (Helper.isNullOrEmpty(extraServiceName))
            return null;

        if (!(price > 0))
            return null;

        String id = Helper.generateID();

        return new ExtraService.Builder()
                .setExtraServiceId(id)
                .setExtraServiceName(extraServiceName)
                .setPrice(price)
                .build();
    }

}
