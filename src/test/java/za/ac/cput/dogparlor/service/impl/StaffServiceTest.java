package za.ac.cput.dogparlor.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.dogparlor.domain.Role;
import za.ac.cput.dogparlor.domain.Staff;
import za.ac.cput.dogparlor.factory.StaffFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class StaffServiceTest {

    @Autowired
    private StaffService service;
    private static Staff staff = null;

    public StaffServiceTest() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role.Builder().setRoleID("someIdtest").setName("").build());
        staff = StaffFactory.createStaff("Onodwa", "Siyotula", "SomeRole", roles);
    }

    @Order(1)
    @Test
    void create() {
        Staff staff1 = service.create(staff);
        System.out.println(staff1.getStaffNumber());
        assertNotNull(staff1);
        System.out.println("Created: " + staff1);
    }

    @Order(2)
    @Test
    void read() {
        Staff staff1 = service.read(staff.getStaffNumber());
        assertNotNull(staff1);
        System.out.println("Read: " + staff1);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}