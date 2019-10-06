package ac.za.cput.service.impl;

import ac.za.cput.factory.UserContactFactory;
import ac.za.cput.repository.UserContactRep;
import ac.za.cput.service.UserContactService;
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
public class UserContactServiceImplTest {
    @Autowired
    private UserContactService service;

    @Test
    public void a_create() {
        service.create(UserContactFactory.getUserContact("123456789", "1112223344", "", ""));
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void c_update() {
        //create();
        //service.create(UserContactFactory.getUserContact("123456789", "1112223344", "", ""));
        service.update(UserContactFactory.getUserContact("123456789", "2221114432", "144991044", "0000000000"));
        assertEquals("0000000000", service.read("123456789").getCellPhone());
    }

    @Test
    public void d_delete() {
//        create();
        //assertTrue(service.delete("123456789"));
        //asssertNull(service.read("123456789"));
    }

    @Test
    public void b_read() {
        //create();
        assertNotNull(service.read("123456789"));
    }
}