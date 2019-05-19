package ac.za.cput.repository.impl;

import ac.za.cput.domain.UserContact;
import ac.za.cput.factory.UserContactFactory;
import ac.za.cput.repository.UserContactRep;
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
public class UserContactRepImplTest {
    @Autowired
    private UserContactRep repository;

    @Test
    public void a_create() {
        repository.create(UserContactFactory.getUserContact("123456789", "1112223344", "", ""));
        assertEquals(1, repository.getAll().size());
    }

    @Test
    public void c_update() {
        //create();

        repository.update(UserContactFactory.getUserContact("123456789", "2221114432", "144991044", "0000000000"));
        assertEquals("0000000000", repository.read("123456789").getCellPhone());
    }

    @Test
    public void d_delete() {
//        create();
        assertTrue(repository.delete("123456789"));
        assertNull(repository.read("123456789"));
    }

    @Test
    public void b_read() {
        //create();
        assertNotNull(repository.read("123456789"));
    }
}