package ac.za.cput.repository.impl;

import ac.za.cput.domain.UserAddress;
import ac.za.cput.factory.UserAddressFactory;
import ac.za.cput.repository.UserAddressRep;
import org.junit.Assert;
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
public class UserAddressRepImplTest {
    @Autowired
    private UserAddressRep repository;


    @Test
    public void a_create() {
        repository.create(UserAddressFactory.getUserAddress("123456789", "1 Adderley St", "", "Cape Town", "WC", 8001));
        Assert.assertEquals(1, repository.getAll().size());
    }

    @Test
    public void d_update() {
        //create();
        repository.update(UserAddressFactory.getUserAddress("123456789", "2 Long St", "", "Cape Town", "WC", 8001));
        assertEquals("2 Long St", repository.read("123456789").getAddrLine1());
    }

    @Test
    public void f_delete() {
        //create();
        assertTrue(repository.delete("123456789"));
    }

    @Test
    public void c_read() {
        //create();
        assertNotNull(repository.read("123456789"));
    }

    @Test
    public void b_getAll()
    {
        //create();
        repository.create(UserAddressFactory.getUserAddress("123456787", "1 Adderley St", "", "Cape Town", "WC", 8001));
        repository.create(UserAddressFactory.getUserAddress("123456788", "1 Adderley St", "", "Cape Town", "WC", 8001));
        assertEquals(3, repository.getAll().size());
    }
}