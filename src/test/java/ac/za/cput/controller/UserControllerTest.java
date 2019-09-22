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

}