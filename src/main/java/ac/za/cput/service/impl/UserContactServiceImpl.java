package ac.za.cput.service.impl;

import ac.za.cput.domain.UserContact;
import ac.za.cput.repository.UserContactRep;
import ac.za.cput.service.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserContactServiceImpl implements UserContactService {
    @Autowired
    private UserContactRep repository;

    @Override
    public List<UserContact> getAll() {
        return this.repository.findAll();
    }

    @Override
    public UserContact create(UserContact userContact) {
        return this.repository.save(userContact);
    }

    @Override
    public UserContact update(UserContact userContact) {
        return this.repository.save(userContact);
    }

    @Override
    public void delete(UserContact s) {
        this.repository.delete(s);
    }

    @Override
    public UserContact read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
