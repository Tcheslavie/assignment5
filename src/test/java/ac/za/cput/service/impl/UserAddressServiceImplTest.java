package ac.za.cput.service.impl;

import ac.za.cput.factory.UserAddressFactory;
import ac.za.cput.repository.UserAddressRep;
import ac.za.cput.repository.impl.UserAddressRepImpl;
import ac.za.cput.service.UserAddressService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserAddressServiceImplTest {
    @Autowired
    private UserAddressService service;

    @Test
    public void a_create() {
        service.create(UserAddressFactory.getUserAddress("123456789", "1 Adderley St", "", "Cape Town", "WC", 8001));
        Assert.assertEquals(1, service.getAll().size());
    }

    @Test
    public void c_update() {
        //create();
        service.update(UserAddressFactory.getUserAddress("123456789", "2 Long St", "", "Cape Town", "WC", 8001));
        assertEquals("2 Long St", service.read("123456789").getAddrLine1());
    }

    @Test
    public void d_delete() {
//        create();
        assertTrue(service.delete("123456789"));
    }

    @Test
    public void b_read() {
//        create();
        assertNotNull(service.read("123456789"));
    }

    @Test
    public void getAll()
    {
//        create();
        service.create(UserAddressFactory.getUserAddress("123456789", "1 Adderley St", "", "Cape Town", "WC", 8001));
        service.create(UserAddressFactory.getUserAddress("123456788", "1 Adderley St", "", "Cape Town", "WC", 8001));
        assertEquals(2, service.getAll().size());
    }
}