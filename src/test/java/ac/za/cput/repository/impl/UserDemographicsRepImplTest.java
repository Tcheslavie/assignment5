package ac.za.cput.repository.impl;

import ac.za.cput.domain.UserDemographics;
import ac.za.cput.factory.UserDemographicsFactory;
import ac.za.cput.repository.UserDemographicsRep;
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
public class UserDemographicsRepImplTest {
    @Autowired
    private UserDemographicsRep repository;

    @Test
    public void a_create() {
        repository.create(UserDemographicsFactory.getUserDemographics("123456789", "M", "W"));
        assertEquals(1, repository.getAll().size());
    }

    @Test
    public void b_update() {
        //create();
        repository.create(UserDemographicsFactory.getUserDemographics("123456789", "M", "W"));
        repository.update(UserDemographicsFactory.getUserDemographics("123456789", "F", "B"));
        assertEquals("F", repository.read("123456789").getGender());
    }

    @Test
    public void d_delete() {
        //create();
        assertTrue(repository.delete("123456789"));
    }

    @Test
    public void c_read() {
        //create();
        assertEquals("F", repository.read("123456789").getGender());
    }
}