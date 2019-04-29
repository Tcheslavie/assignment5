package ac.za.cput.repository.impl;

import ac.za.cput.domain.User;
import ac.za.cput.factory.UserFactory;
import ac.za.cput.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class UserRepImplTest {
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = UserRepImpl.getRepository();
    }

    @Test
    public void create() {
        String idnr = "1234567891234";
        User u = UserFactory.getUser(idnr, "John", "Bush");
        repository.create(u);
        Assert.assertEquals(1, repository.getAll().size());
    }

    @Test
    public void update() {
        create();
        String idnr = "1234567891234";
        User u = UserFactory.getUser(idnr, "Johnson", "Bush");
        u = repository.update(u);
        Assert.assertEquals("Johnson Bush", u.getName());
    }

    @Test
    public void delete() {
        String idnr = "1234567891234";
        create();
        repository.delete(idnr);
        assertNull(repository.read(idnr));
    }

    @Test
    public void read() {
        create();
        String idnr = "1234567891234";
        User u = repository.read(idnr);
        Assert.assertNotNull(u.getIdnumber());

    }

    @Test
    public void getAll() {
        create();
        Assert.assertEquals(1, repository.getAll().size());
    }
}
