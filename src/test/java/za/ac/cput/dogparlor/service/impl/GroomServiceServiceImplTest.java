package za.ac.cput.dogparlor.service.impl;

        import org.junit.jupiter.api.MethodOrderer;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.TestMethodOrder;
        import org.springframework.boot.test.context.SpringBootTest;
        import za.ac.cput.dogparlor.domain.GroomService;
        import za.ac.cput.dogparlor.factory.GroomServiceFactory;

        import java.util.List;
        import java.util.Set;

        import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class GroomServiceServiceImplTest {
    private GroomServiceServiceImpl groomServiceService = null;
    private GroomService groomService = GroomServiceFactory.createService("Washing", " Basic dog washing", "1 hour", 80.00, "washing.png");

    @Test
    void a_create() {
        GroomService groomService1 = groomServiceService.create(groomService);
        assertNotNull(groomService1);
        System.out.println("Created: " + groomService1);
    }

    @Test
    void b_read() {
        GroomService groomService1 = groomServiceService.read(groomService.getServiceId());
        assertNotNull(groomService1);
        System.out.println("Read: " + groomService1);
    }

    @Test
    void c_update() {
        GroomService groomService1 = new GroomService.Builder().copy(groomService)
                .setServiceId("1478")
                .build();
        GroomService updated = groomServiceService.update(groomService1);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    void e_delete() {
        boolean deleted = groomServiceService.delete(groomService.getServiceId());
        assertTrue(deleted);
        System.out.println("Deleted: " + (deleted ? "Yes" : "No"));
    }
    @Test
    void d_getAll() {
        List<GroomService> groomServices = groomServiceService.getAll();
        assertNotNull(groomServices);
        System.out.println("All items: " + groomServices);
    }
}

