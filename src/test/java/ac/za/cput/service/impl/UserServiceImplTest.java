package ac.za.cput.service.impl;

import ac.za.cput.domain.User;
import ac.za.cput.factory.UserFactory;
import ac.za.cput.repository.UserRepository;
import ac.za.cput.repository.impl.UserRepImpl;
import ac.za.cput.service.UserService;
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
public class UserServiceImplTest {
    @Autowired
    private UserService service;

    @Test
    public void a_create() {
        String idnr = "1234567891234";
        User u = UserFactory.getUser(idnr, "John", "Bush");
        service.create(u);
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void d_update() {
        User u = UserFactory.getUser("1234567891234", "Johnson", "Bush");
        u = service.update(u);
        Assert.assertEquals("Johnson Bush", u.getName());
    }

    @Test
    public void e_delete() {

        service.delete("1234567891234");
        assertNull(service.read("1234567891234"));
    }

    @Test
    public void c_read() {
        User u = service.read("1234567891234");
        Assert.assertNotNull(u.getIdnumber());

    }

    @Test
    public void b_getAll() {
        Assert.assertEquals(1, service.getAll().size());
    }
}