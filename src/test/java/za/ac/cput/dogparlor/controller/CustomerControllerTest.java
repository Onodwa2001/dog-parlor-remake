package za.ac.cput.dogparlor.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.dogparlor.domain.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    private final int customer;

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/customer";

    CustomerControllerTest(Object Customer) {

        customer = Customer.hashCode();
    }

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Customer savedCustomer= postResponse.getBody();
        System.out.println("Saved data: " + savedCustomer);
        assertEquals(customer, savedCustomer.getCustomerID());
    }

    @Test
    void read() {
        var url = baseURL + "/read/" + customer;
        System.out.println("URL: " + url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertEquals(customer, response.getBody().getCustomerID());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        Customer updatedCustomerAddress = new Customer.Builder().copy(customer)
                .setCustomerID("zee")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updatedCustomerAddress);
        var response = restTemplate.postForEntity(url, updatedCustomerAddress, Customer.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void delete() {
        String url = baseURL + "/delete/" + customer;
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
