package ac.za.cput.repository.impl;

import ac.za.cput.domain.User;
import ac.za.cput.factory.UserFactory;
import ac.za.cput.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepImplTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void a_create() {
        String idnr = "1234567891234";
        User u = UserFactory.getUser(idnr, "John", "Bush");
        repository.create(u);
        assertEquals(1, repository.getAll().size());
    }

    @Test
    public void d_update() {
        User u = UserFactory.getUser("1234567891234", "Johnson", "Bush");
        u = repository.update(u);
        Assert.assertEquals("Johnson Bush", u.getName());
    }

    @Test
    public void e_delete() {

        repository.delete("1234567891234");
        assertNull(repository.read("1234567891234"));
    }

    @Test
    public void c_read() {
        User u = repository.read("1234567891234");
        Assert.assertNotNull(u.getIdnumber());

    }

    @Test
    public void b_getAll() {
        Assert.assertEquals(1, repository.getAll().size());
    }
}
