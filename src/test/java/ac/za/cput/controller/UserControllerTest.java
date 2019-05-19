package ac.za.cput.controller;

import ac.za.cput.domain.User;
import ac.za.cput.domain.UserAddress;
import ac.za.cput.domain.UserContact;
import ac.za.cput.domain.UserDemographics;
import ac.za.cput.factory.UserAddressFactory;
import ac.za.cput.factory.UserContactFactory;
import ac.za.cput.factory.UserDemographicsFactory;
import ac.za.cput.factory.UserFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import javax.jws.soap.SOAPBinding;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/user";

    @Test
    public void a_create() {
        User u = UserFactory.getUser("123456789", "Henry", "Maine");

        ResponseEntity<User> postResponse = restTemplate.postForEntity(baseURL + "/create", u, User.class);

        User u2 = UserFactory.getUser("123456788", "Henry", "Maine");

        ResponseEntity<User> postResponse2 = restTemplate.postForEntity(baseURL + "/create", u, User.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void d_update() {
        int id = 123456789;
        User u = restTemplate.getForObject(baseURL + "/read/" + id, User.class);
        User u2 = UserFactory.getUser(u.getIdnumber(), "Mark", "Maine");

        restTemplate.put(baseURL + "/update/" + id, u2);
        User updated = restTemplate.getForObject(baseURL + "/read/" + id, User.class);
        assertNotNull(updated);
    }

    @Test
    public void e_delete() {
        int id = 123456788;
        User u = restTemplate.getForObject(baseURL + "/read/" + id, User.class);
        assertNotNull(u);
        restTemplate.delete(baseURL + "/delete/" + id);
        try {
            u = restTemplate.getForObject(baseURL + "/read/" + id, User.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void c_read() {
        User u = restTemplate.getForObject(baseURL + "/read/123456789", User.class);
        assertNotNull(u);
    }

    @Test
    public void b_getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void f_updateAddr() {
        int id = 123456789;
        UserAddress u2 = UserAddressFactory.getUserAddress(String.valueOf(id), "1 Adderley St", "", "Cape Town", "WC", 8001);

        restTemplate.put(baseURL + "/address/update/" + id, u2);
        UserAddress updated = restTemplate.getForObject(baseURL + "/address/read/" + id, UserAddress.class);
        assertNotNull(updated);
    }
    @Test
    public void g_getAddr() {
        UserAddress u = restTemplate.getForObject(baseURL + "/address/read/123456789", UserAddress.class);
        assertNotNull(u);

    }
    @Test
    public void f_updateContact() {
        int id = 123456789;
        UserContact u2 = UserContactFactory.getUserContact(String.valueOf(id), "", "", "0765510441");

        restTemplate.put(baseURL + "/contact/update/" + id, u2);
        UserContact updated = restTemplate.getForObject(baseURL + "/contact/read/" + id, UserContact.class);
        assertNotNull(updated);
    }
    @Test
    public void g_getContact() {
        UserContact u = restTemplate.getForObject(baseURL + "/contact/read/123456789", UserContact.class);
        assertNotNull(u);
    }
    @Test
    public void f_updateDemograph() {
        int id = 123456789;
        UserDemographics u2 = UserDemographicsFactory.getUserDemographics(String.valueOf(id), "M", "White");

        restTemplate.put(baseURL + "/demographics/update/" + id, u2);
        UserDemographics updated = restTemplate.getForObject(baseURL + "/demographics/read/" + id, UserDemographics.class);
        assertNotNull(updated);
    }
    @Test
    public void g_getDemograph() {
        int id = 123456789;
        UserDemographics u = restTemplate.getForObject(baseURL + "/demographics/read/" + id, UserDemographics.class);
        assertNotNull(u);
    }
}