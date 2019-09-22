package ac.za.cput.factory;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.Party;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartyFactoryTest {

    @Test
    public void getParty() {
        Party pf = PartyFactory.getParty( "DA");
        Assert.assertNotNull(pf);
    }
}