package ac.za.cput.factory;

import ac.za.cput.domain.UserDemographics;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDemographicsFactoryTest {

    @Test
    public void getUserDemographics() {
        UserDemographics uf = UserDemographicsFactory.getUserDemographics("1234567891234", "male", "african");
        Assert.assertNotNull(uf.getGender());
    }
}