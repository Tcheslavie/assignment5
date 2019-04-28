package ac.za.cput.factory;

import ac.za.cput.domain.Election;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElectionFactoryTest {

    @Test
    public void getElection() {
        Election el = ElectionFactory.getElection(2018, CandidateFactory.getCandidate("1", "Test", "Test", "1"));
        Assert.assertNotNull(el.getYear());
    }
}