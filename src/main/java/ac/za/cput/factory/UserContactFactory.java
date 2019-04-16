package ac.za.cput.factory;

import ac.za.cput.domain.UserContact;

public class UserContactFactory {
    public static UserContact getUserContact(String home, String work, String cell)
    {
        return new UserContact.Builder().homePhone(home).workPhone(work).cellPhone(cell).build();
    }
}
