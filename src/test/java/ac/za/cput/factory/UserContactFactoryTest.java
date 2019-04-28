package ac.za.cput.factory;

import ac.za.cput.domain.UserContact;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserContactFactoryTest {

    @Test
    public void getUserContact() {
        UserContact uf = UserContactFactory.getUserContact("123456789","123456778", "", "");
        Assert.assertNotNull(uf.getCellPhone());
    }
}