package za.ac.cput.dogparlor.controller;

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
import za.ac.cput.dogparlor.domain.Booking;
import za.ac.cput.dogparlor.factory.BookingFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookingControllerTest {

    private final Booking booking;
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL = "http://localhost:8080/booking";

    BookingControllerTest() {
        booking = BookingFactory.createBooking("zee", "19", "3", "washing");
    }


    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Booking> postResponse = testRestTemplate.postForEntity(url, booking, Booking.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Booking savedBooking = postResponse.getBody();
        System.out.println("Saved data: " + savedBooking);
        assertEquals(booking.getBookingID(), savedBooking.getBookingID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + booking.getBookingID();
        ResponseEntity<Booking> responseEntity = testRestTemplate.getForEntity(url, Booking.class);
        assertEquals(booking.getBookingID(), responseEntity.getBody().getBookingID());
        System.out.println(responseEntity.getBody());
    }

    @Test
    void c_update() {
        Booking updatedBooking = new Booking.BookingBuilder().copy(booking)
                .setBookingID("zee")
                .build();

        String url = baseURL + "/update";
        ResponseEntity<Booking> responseEntity = testRestTemplate.postForEntity(url, updatedBooking, Booking.class);
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + booking.getBookingID();
        System.out.println("URL: " + url);
        testRestTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
