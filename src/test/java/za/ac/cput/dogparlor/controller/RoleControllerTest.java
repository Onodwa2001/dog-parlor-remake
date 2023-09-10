/* RoleControllerTest.java
  Entity for the Role
  Author: Byron Young (218155077)
  Date:27 August 2023
 */
package za.ac.cput.dogparlor.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.dogparlor.domain.Role;
import za.ac.cput.dogparlor.factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoleControllerTest {
    private static Role role = RoleFactory.createRole("Dog stylist");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/role";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Role> postResponse = restTemplate.postForEntity(url, role, Role.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Role savedRole = postResponse.getBody();
        System.out.println("Saved data: " + savedRole);
        assertEquals(role.getRoleID(), savedRole.getRoleID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + role.getRoleID();
        System.out.println("URL" + url);
        ResponseEntity<Role> responseEntity = restTemplate.getForEntity(url, Role.class);
        assertEquals(role.getRoleID(), responseEntity.getBody().getRoleID());
        System.out.println(responseEntity.getBody());
    }

    @Test
    void c_update() {
        Role updatedRole = new Role.Builder().copy(role)
                .setName("Dog specialist")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updatedRole);
        ResponseEntity<Role> responseEntity = restTemplate.postForEntity(url, updatedRole, Role.class);
        assertNotNull(responseEntity.getBody());
    }

    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + role.getRoleID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}