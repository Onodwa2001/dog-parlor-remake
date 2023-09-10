package za.ac.cput.dogparlor.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.dogparlor.domain.ExtraService;
import za.ac.cput.dogparlor.factory.ExtraServiceFactory;
import za.ac.cput.dogparlor.service.impl.ExtraServiceService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ExtraServiceServiceTest {

    private ExtraServiceService extraServiceService = null;
    private ExtraService extraService = ExtraServiceFactory.createExtraService("Hair cutting",120.00);

    @Test
    void a_create() {
        ExtraService extraService1 = extraServiceService.create(extraService);
        assertNotNull(extraService1);
        System.out.println("Created: " + extraService1);
    }

    @Test
    void b_read() {
        ExtraService extraService1 = extraServiceService.read(extraService.getExtraServiceName());
        assertNotNull(extraService1);
        System.out.println("Read: " + extraService1);
    }

    @Test
    void c_update() {
        ExtraService extraService1 = new ExtraService.Builder().copy(extraService)
                .setExtraServiceName("Love")
                .build();
        ExtraService updated = extraServiceService.update(extraService1);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean deleted = extraServiceService.delete(extraService.getExtraServiceName());
        assertTrue(deleted);
        System.out.println("Deleted: " + (deleted ? "Yes" : "No"));
    }

    @Test
    void d_getAll() {
        List<ExtraService> extraServices = extraServiceService.getAllExtraServices();
        assertNotNull(extraServices);
        System.out.println("All items: " + extraServices);
    }
}
