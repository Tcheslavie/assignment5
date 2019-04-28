package ac.za.cput.factory;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.Party;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartyFactoryTest {

    @Test
    public void getParty() {
        Candidate c1 = CandidateFactory.getCandidate("1", "John", "Test", "1");
        Candidate c2 = CandidateFactory.getCandidate("2", "John2", "Test2", "1");
        Party pf = PartyFactory.getParty("1", "DA", c1,c2);
        Assert.assertNotNull(pf.getCandidates().get(1).getName());
    }
}