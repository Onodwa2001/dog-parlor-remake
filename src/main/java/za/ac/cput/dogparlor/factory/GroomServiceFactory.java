package za.ac.cput.dogparlor.factory;

import za.ac.cput.dogparlor.domain.ExtraService;
import za.ac.cput.dogparlor.domain.GroomService;
import za.ac.cput.dogparlor.util.Helper;

import java.util.List;

public class GroomServiceFactory {

    public static GroomService createService(String name, String description,
                                             String serviceDuration, double price, String image) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description)
                || Helper.isNullOrEmpty(serviceDuration) || price < 0)
            return null;

        String serviceId = Helper.generateID();

        return new GroomService.Builder()
                .setServiceId(serviceId)
                .setName(name)
                .setDescription(description)
                .setServiceDuration(serviceDuration)
                .setPrice(price)
                .setImage(image)
                .build();
    }

}
