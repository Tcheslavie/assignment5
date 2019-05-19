package ac.za.cput.controller;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.Party;
import ac.za.cput.domain.User;
import ac.za.cput.factory.PartyFactory;
import ac.za.cput.factory.UserFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

public class PartyControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/party";

    @Test
    public void a_create() {
        Party p = PartyFactory.getParty("1", "ANC", null);

        ResponseEntity<Party> postResponse = restTemplate.postForEntity(baseURL + "/create", p, Party.class);

        Party p2 = PartyFactory.getParty("2", "DA", null);

        ResponseEntity<Party> postResponse2 = restTemplate.postForEntity(baseURL + "/create", p2, Party.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void d_update() {
        int id = 1;
        Party p = restTemplate.getForObject(baseURL + "/read/" + id, Party.class);
        Party p2 = PartyFactory.getParty(p.getPartyId(), "DA Plus", null);

        restTemplate.put(baseURL + "/update/" + id, p2);
        Party updated = restTemplate.getForObject(baseURL + "/read/" + id, Party.class);
        assertNotNull(updated);
    }

    @Test
    public void e_delete() {
        int id = 2;
        Party p = restTemplate.getForObject(baseURL + "/read/" + id, Party.class);
        assertNotNull(p);
        restTemplate.delete(baseURL + "/delete/" + id);
        try {
            p = restTemplate.getForObject(baseURL + "/read/" + id, Party.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void c_read() {
        Party p = restTemplate.getForObject(baseURL + "/read/1", Party.class);
        assertNotNull(p);
    }

    @Test
    public void b_getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}