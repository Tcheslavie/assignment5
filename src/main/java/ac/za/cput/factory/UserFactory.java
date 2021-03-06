package ac.za.cput.factory;


import ac.za.cput.domain.User;
import ac.za.cput.domain.UserVoting;

public class UserFactory {
    public static User getUser(String idnumber, String fname, String lname){
        return new User.Builder().idnumber(idnumber).uname(fname).lname(lname).build();
    }
}
