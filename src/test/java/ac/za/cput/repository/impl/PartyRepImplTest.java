package ac.za.cput.repository.impl;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.Party;
import ac.za.cput.factory.CandidateFactory;
import ac.za.cput.factory.PartyFactory;
import ac.za.cput.repository.PartyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartyRepImplTest {
    private PartyRepository repository;
    private Candidate c;
    @Before
    public void setUp() throws Exception {
        this.repository = PartyRepImpl.getRepository();
        c = CandidateFactory.getCandidate("1", "John", "Smith", "1");
    }

    @Test
    public void getAll() {
        create();
        assertEquals(3, repository.getAll().size());
    }

    @Test
    public void findByName() {
        create();
        assertNotNull("DA", repository.findByName("DA"));
    }

    @Test
    public void create() {

        repository.create(PartyFactory.getParty("1", "ANC", c));
        repository.create(PartyFactory.getParty("2", "DA", c));
        repository.create(PartyFactory.getParty("3", "EFF", c));

        Assert.assertEquals(3, repository.getAll().size());
    }

    @Test
    public void update() {
        create();
        repository.update(PartyFactory.getParty("2", "FFP", c));
        Assert.assertEquals("FFP", repository.read("2").getName());
    }

    @Test
    public void delete() {
        create();
        repository.delete("2");
        Assert.assertNull(repository.read("2"));
    }

    @Test
    public void read() {
        repository.create(PartyFactory.getParty("1", "ANC", c));
        Assert.assertNotNull(repository.read("1"));
    }
}