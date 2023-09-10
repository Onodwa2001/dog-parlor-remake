/* RoleServiceTest.java
  Entity for the Role
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.dogparlor.domain.Role;
import za.ac.cput.dogparlor.factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class RoleServiceTest {
    @Autowired
    private RoleService service;

    private static Role role = RoleFactory.createRole("Dog groomer");
    @Test
    void a_create() {
        Role createdRole = service.create(role);
        assertEquals(role.getRoleID(),createdRole.getRoleID());
        System.out.println("Created" + createdRole);
    }

    @Test
    void b_read() {
        Role readRole = service.read(role.getRoleID());
        assertNotNull(readRole);
        System.out.println("Read" + readRole);
    }

    @Test
    void c_update() {
        Role newRole = new Role.Builder().copy(role).setName("Dog stylist").build();
        Role updateRole = service.update(newRole);
        assertEquals(newRole.getName() , updateRole.getName());
        System.out.println("Updated" + updateRole);
    }

    @Test
    void e_delete() {
        boolean deleteRole = service.delete(role.getRoleID());
        assertTrue(deleteRole);
        System.out.println("Deleted: " + (deleteRole ? "Record was successfully deleted" : "Record could not be deleted"));
    }

    @Test
    void d_getAll() {
        System.out.println("Get All");
        System.out.println(service.getAll());
    }
}