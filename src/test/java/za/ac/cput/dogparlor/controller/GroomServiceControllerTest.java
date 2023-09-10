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
    import za.ac.cput.dogparlor.domain.GroomService;
     import za.ac.cput.dogparlor.factory.GroomServiceFactory;
    import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GroomServiceControllerTest {

    private GroomService   groomService = GroomServiceFactory.createService("Washing","Normal washing","1 hour",80.00,"washing.png");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/groomService";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<GroomService> postResponse = restTemplate.postForEntity(url, groomService, GroomService.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        GroomService savedGroomService = postResponse.getBody();
        System.out.println("Saved data: " + savedGroomService);
        assertEquals(groomService.getServiceId(), savedGroomService.getServiceId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + groomService.getServiceId();
        ResponseEntity<GroomService> responseEntity = restTemplate.getForEntity(url, GroomService.class);
        assertEquals(groomService.getServiceId(), responseEntity.getBody().getServiceId());
        System.out.println(responseEntity.getBody());
    }

    @Test
    void c_update() {
        GroomService updatedGroomService = new GroomService.Builder().copy(groomService)
                .setName("Trim")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updatedGroomService);
        ResponseEntity<GroomService> responseEntity = restTemplate.postForEntity(url, updatedGroomService, GroomService.class);
        assertNotNull(responseEntity.getBody());
    }

    @Test
    @Disabled
    void e_delete() {
        String url = baseURL + "/delete/" + groomService.getServiceId();
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