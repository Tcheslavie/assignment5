package ac.za.cput.service.impl;

import ac.za.cput.domain.UserContact;
import ac.za.cput.repository.UserContactRep;
import ac.za.cput.repository.impl.UserContactRepImpl;
import ac.za.cput.service.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("UserContactServiceImpl")
public class UserContactServiceImpl implements UserContactService {
    @Autowired
    @Qualifier("UserContactRep")
    private UserContactRep repository;

    @Override
    public Set<UserContact> getAll() {
        return this.repository.getAll();
    }

    @Override
    public UserContact create(UserContact userContact) {
        return this.repository.create(userContact);
    }

    @Override
    public UserContact update(UserContact userContact) {
        return this.repository.update(userContact);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public UserContact read(String s) {
        return this.repository.read(s);
    }
}
