package ac.za.cput.factory;

import ac.za.cput.domain.Candidate;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandidateFactoryTest {

    @Test
    public void getCandidate() {
        Candidate cf = CandidateFactory.getCandidate("1", "John", "Test", "1");
        Assert.assertNotNull(cf.getName());
    }
}