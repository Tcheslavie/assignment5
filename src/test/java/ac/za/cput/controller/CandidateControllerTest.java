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

public class CandidateControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void create() {
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity("http://localhost:8080/candidate/create/John/Doe/MyParty", null, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}