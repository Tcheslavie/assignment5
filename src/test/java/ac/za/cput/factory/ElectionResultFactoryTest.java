package ac.za.cput.factory;

import ac.za.cput.domain.ElectionResult;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElectionResultFactoryTest {

    @Test
    public void getElectionResult() {
        ElectionResult er = ElectionResultFactory.getElectionResult(2018, 1);
        Assert.assertNotNull(er.getCandidateId());
    }
}