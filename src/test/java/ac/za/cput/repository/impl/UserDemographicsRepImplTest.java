package ac.za.cput.repository.impl;

import ac.za.cput.domain.UserDemographics;
import ac.za.cput.factory.UserDemographicsFactory;
import ac.za.cput.repository.UserDemographicsRep;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDemographicsRepImplTest {
    private UserDemographicsRep repository;
    @Before
    public void setUp() throws Exception {
        repository = UserDemographicsRepImpl.getRepository();
    }

    @Test
    public void getRepository() {
        repository = UserDemographicsRepImpl.getRepository();
        assertNotNull(repository);
    }

    @Test
    public void create() {
        repository.create(UserDemographicsFactory.getUserDemographics("123456789", "M", "W"));
        assertEquals(1, repository.getAll().size());
    }

    @Test
    public void update() {
        create();
        repository.update(UserDemographicsFactory.getUserDemographics("123456789", "F", "B"));
        assertEquals("F", repository.read("123456789").getGender());
    }

    @Test
    public void delete() {
        create();
        assertTrue(repository.delete("123456789"));
    }

    @Test
    public void read() {
        create();
        assertEquals("M", repository.read("123456789").getGender());
    }
}