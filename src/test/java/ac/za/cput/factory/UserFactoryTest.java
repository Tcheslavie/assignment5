package ac.za.cput.factory;

import ac.za.cput.domain.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest {
    @Test
    public void getUser()
    {
        String idnr = "1234567891234";
        User u = UserFactory.getUser(idnr, "John", "Bush");
        System.out.println(u.getName());
        Assert.assertNotNull(((User) u).getIdnumber());

    }

}