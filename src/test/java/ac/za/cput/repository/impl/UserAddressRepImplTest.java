package ac.za.cput.repository.impl;

import ac.za.cput.domain.UserAddress;
import ac.za.cput.factory.UserAddressFactory;
import ac.za.cput.repository.UserAddressRep;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserAddressRepImplTest {
    private UserAddressRep repository;
    @Before
    public void setUp() throws Exception {
        repository= UserAddressRepImpl.getRepository();
    }

    @Test
    public void getRepository() {
        repository= UserAddressRepImpl.getRepository();
        Assert.assertNotNull(repository);
    }

    @Test
    public void create() {
        repository.create(UserAddressFactory.getUserAddress("123456789", "1 Adderley St", "", "Cape Town", "WC", 8001));
        Assert.assertEquals(1, repository.getAll().size());
    }

    @Test
    public void update() {
        create();
        repository.update(UserAddressFactory.getUserAddress("123456789", "2 Long St", "", "Cape Town", "WC", 8001));
        assertEquals("2 Long St", repository.read("123456789").getAddrLine1());
    }

    @Test
    public void delete() {
        create();
        assertTrue(repository.delete("123456789"));
    }

    @Test
    public void read() {
        create();
        assertNotNull(repository.read("123456789"));
    }

    @Test
    public void getAll()
    {
        create();

        assertEquals(1, repository.getAll().size());
    }
}