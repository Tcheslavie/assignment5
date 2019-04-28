package ac.za.cput.repository.impl;

import ac.za.cput.domain.UserContact;
import ac.za.cput.factory.UserContactFactory;
import ac.za.cput.repository.UserContactRep;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserContactRepImplTest {
    private UserContactRep repository;
    @Before
    public void setUp() throws Exception {
        repository = UserContactRepImpl.getRepository();
    }

    @Test
    public void getRepository() {
        repository = UserContactRepImpl.getRepository();
        assertNotNull(repository);
    }

    @Test
    public void create() {
        repository.create(UserContactFactory.getUserContact("123456789", "1112223344", "", ""));
        assertEquals(1, repository.getAll().size());
    }

    @Test
    public void update() {
        create();
        repository.update(UserContactFactory.getUserContact("123456789", "2221114432", "144991044", "0000000000"));
        assertEquals("0000000000", repository.read("123456789").getCellPhone());
    }

    @Test
    public void delete() {
        create();
        assertTrue(repository.delete("123456789"));
        assertNull(repository.read("123456789"));
    }

    @Test
    public void read() {
        create();
        assertNotNull(repository.read("123456789"));
    }
}