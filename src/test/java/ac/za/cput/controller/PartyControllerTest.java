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

}