package ac.za.cput.repository.impl;

import ac.za.cput.domain.UserContact;
import ac.za.cput.repository.UserContactRep;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.Set;
@Repository("UserContactRep")
public class UserContactRepImpl implements UserContactRep {
    private static UserContactRep repository = null;
    private Set<UserContact> contacts;
    private UserContactRepImpl()
    {
        contacts = new HashSet<>();
    }

    public static UserContactRep getRepository()
    {
        if(repository==null) repository = new UserContactRepImpl();
        return repository;
    }
    @Override
    public Set<UserContact> getAll() {
        return this.contacts;
    }

    @Override
    public UserContact create(UserContact userContact) {
        this.contacts.add(userContact);
        return userContact;
    }

    @Override
    public UserContact update(UserContact userContact) {

        for(UserContact cont : contacts)
        {
            if(cont.getIdNumber().equals(userContact.getIdNumber()))
            {
                this.contacts.remove(cont);
                this.contacts.add(userContact);
                return userContact;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        for(UserContact cont : contacts)
        {
            if(cont.getIdNumber().equals(s))
            {
                this.contacts.remove(cont);
                return true;
            }
        }
        return false;
    }

    @Override
    public UserContact read(String s) {
        for(UserContact cont : contacts)
        {
            if(cont.getIdNumber().equals(s)) return cont;
        }
        return null;
    }
}
