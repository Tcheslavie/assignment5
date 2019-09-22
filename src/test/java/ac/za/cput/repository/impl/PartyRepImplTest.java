package ac.za.cput.repository.impl;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.Party;
import ac.za.cput.factory.CandidateFactory;
import ac.za.cput.factory.PartyFactory;
import ac.za.cput.repository.PartyRepository;
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
public class PartyRepImplTest {
    @Autowired
    private PartyRepository repository;

    @Test
    public void b_getAll() {
        assertEquals(3, repository.getAll().size());
    }

    @Test
    public void a_create() {

        repository.create(PartyFactory.getParty("ANC"));
        repository.create(PartyFactory.getParty("DA"));
        repository.create(PartyFactory.getParty("EFF"));

        Assert.assertEquals(3, repository.getAll().size());
    }

    @Test
    public void e_update() {
        repository.update(PartyFactory.getParty("FFP"));
        Assert.assertEquals("FFP", repository.read("2").getName());
    }

    @Test
    public void f_delete() {
        repository.delete("2");
        Assert.assertNull(repository.read("2"));
    }

    @Test
    public void c_read() {
        repository.create(PartyFactory.getParty("ANC"));
        Assert.assertNotNull(repository.read("1"));
    }
}