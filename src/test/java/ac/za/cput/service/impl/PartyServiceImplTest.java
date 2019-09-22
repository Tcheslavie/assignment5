package ac.za.cput.service.impl;

import ac.za.cput.domain.Candidate;
import ac.za.cput.factory.CandidateFactory;
import ac.za.cput.factory.PartyFactory;
import ac.za.cput.service.PartyService;
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
public class PartyServiceImplTest {
    @Autowired
    private PartyService service;

    @Test
    public void e_getAll() {
        assertEquals(3, service.getAll().size());
    }

    @Test
    public void d_findByName() {
        assertNotNull("DA", service.findByName("FFP"));
    }

    @Test
    public void a_create() {

        service.create(PartyFactory.getParty( "ANC"));
        service.create(PartyFactory.getParty( "DA"));
        service.create(PartyFactory.getParty( "EFF"));

        Assert.assertEquals(3, service.getAll().size());
    }

    @Test
    public void c_update() {
        service.update(PartyFactory.getParty( "FFP"));
        Assert.assertEquals("FFP", service.read("2").getName());
    }

    @Test
    public void f_delete() {
        service.delete("2");
        Assert.assertNull(service.read("2"));
    }

    @Test
    public void b_read() {
        Assert.assertNotNull(service.read("1"));
    }
}