package ac.za.cput.factory;

import ac.za.cput.domain.UserVoting;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserVotingFactoryTest {

    @Test
    public void getUserVoting() {
        UserVoting uf = UserVotingFactory.getUserVoting("1234567891234", 2019, 1);
        Assert.assertNotNull(uf.getCandidateId());
    }
}