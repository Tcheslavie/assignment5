package ac.za.cput.service.impl;

import ac.za.cput.domain.User;
import ac.za.cput.repository.UserRepository;
import ac.za.cput.repository.impl.UserRepImpl;
import ac.za.cput.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("UserRep")
    private UserRepository repository;

    @Override
    public Set<User> getAll() {
        return this.repository.getAll();
    }

    @Override
    public User create(User user) {
        return this.repository.create(user);
    }

    @Override
    public User update(User user) {
        return this.repository.update(user);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public User read(String s) {
        return this.repository.read(s);
    }
}
