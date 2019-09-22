package ac.za.cput.factory;

import ac.za.cput.domain.CandidateElection;
import org.junit.Assert;
import org.junit.Test;

public class CandidateElectionFactoryTest {

    @Test
    public void getElectionResult() {
        CandidateElection er = CandidateElectionFactory.getElectionResult(2018, 1);
        Assert.assertNotNull(er.getCandidateId());
    }
}