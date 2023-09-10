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
import za.ac.cput.dogparlor.domain.Dog;
import za.ac.cput.dogparlor.domain.ExtraService;
import za.ac.cput.dogparlor.factory.DogFactory;
import za.ac.cput.dogparlor.factory.ExtraServiceFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExtraServiceControllerTest {

    private ExtraService extraService = ExtraServiceFactory.createExtraService("Hair cutting", 120.00);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/extraService";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<ExtraService> postResponse = restTemplate.postForEntity(url, extraService, ExtraService.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        ExtraService savedExtraService = postResponse.getBody();
        System.out.println("Saved data: " + savedExtraService);
        assertEquals(extraService.getExtraServiceId(), savedExtraService.getExtraServiceId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + extraService.getExtraServiceId();
        ResponseEntity<ExtraService> responseEntity = restTemplate.getForEntity(url, ExtraService.class);
        assertEquals(extraService.getExtraServiceName(), responseEntity.getBody().getExtraServiceName());
        System.out.println(responseEntity.getBody());
    }

    @Test
    void c_update() {
        ExtraService updatedExtraService = new ExtraService.Builder().copy(extraService)
                .setExtraServiceName("Ear cleaning")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updatedExtraService);
        ResponseEntity<ExtraService> responseEntity = restTemplate.postForEntity(url, updatedExtraService, ExtraService.class);
        assertNotNull(responseEntity.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + extraService.getExtraServiceId();
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
