package ac.za.cput.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PartyControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/party";

    @Test
    public void create() {
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/MyParty", null, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void read() {
        ResponseEntity result = restTemplate.withBasicAuth("voter", "elections")
                .getForEntity(BASE_URL + "/read/MyParty", null, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAll() {
        ResponseEntity result = restTemplate.withBasicAuth("voter", "elections")
                .getForEntity(BASE_URL + "/read/all", null, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}