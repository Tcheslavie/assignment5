package ac.za.cput.service.impl;

import ac.za.cput.factory.UserDemographicsFactory;
import ac.za.cput.repository.UserDemographicsRep;
import ac.za.cput.service.UserDemographicsService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDemographicsServiceImplTest {
    @Autowired
    private UserDemographicsService service;

    @Test
    public void a_create() {
        service.create(UserDemographicsFactory.getUserDemographics("123456789", "M", "W"));
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void c_update() {
        //create();
        service.create(UserDemographicsFactory.getUserDemographics("123456789", "M", "W"));
        service.update(UserDemographicsFactory.getUserDemographics("123456789", "F", "B"));
        assertEquals("F", service.read("123456789").getGender());
    }

    @Test
    public void d_delete() {
        //create();
        //assertTrue(service.delete("123456789"));
    }

    @Test
    public void b_read() {
        //create();
        assertEquals("M", service.read("123456789").getGender());
    }
}