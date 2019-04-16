package ac.za.cput.factory;

import ac.za.cput.domain.UserAddress;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserAddressFactoryTest {

    @Test
    public void getUserAddress() {
        UserAddress uf = UserAddressFactory.getUserAddress("123456789123", "12 Long St", "", "Cape Town", "WC", 8001);
        Assert.assertNotNull(uf.getAddrLine1());
    }
}