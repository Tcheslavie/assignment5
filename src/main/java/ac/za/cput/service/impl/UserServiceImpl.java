package ac.za.cput.service.impl;

import ac.za.cput.domain.User;
import ac.za.cput.repository.UserRepository;
import ac.za.cput.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User update(User user) {
        return this.repository.save(user);
    }

    @Override
    public void delete(User s) {
        this.repository.delete(s);
    }

    @Override
    public User read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
