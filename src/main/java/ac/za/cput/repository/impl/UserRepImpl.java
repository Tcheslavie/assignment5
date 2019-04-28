package ac.za.cput.repository.impl;

import ac.za.cput.domain.User;
import ac.za.cput.repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.Set;

public class UserRepImpl implements UserRepository{

    private static UserRepImpl repository = null;
    private Set<User> users;

    private UserRepImpl()
    {
        this.users = new HashSet<>();
    }

    public static UserRepository getRepository()
    {
        if(repository==null) repository = new UserRepImpl();
        return repository;
    }

    private User findUser(String id)
    {
        for (User user : this.users) {
            if (user.getIdnumber().equals(id)) {
                return user;
            }
        }
        return null;
    }
    private User updateUser(User obj)
    {
        String id = obj.getIdnumber();
        if(deleteUser(id))
        {
            this.users.add(obj);
            return findUser(id);
        }
        return null;
    }

    private boolean deleteUser(String id)
    {
        for(User user : this.users)
        {
            if(user.getIdnumber().equals(id))
            {
                this.users.remove(user);
                return true;
            }
        }
        return false;
    }
    @Override
    public User create(User obj) {
        this.users.add(obj);
        return obj;
    }

    @Override
    public User update(User obj) {
        return updateUser(obj);
    }

    @Override
    public boolean delete(String id) {
        return deleteUser(id);
    }

    @Override
    public User read(String id) {
        return findUser(id);
    }

    public Set<User> getAll()
    {
        return this.users;
    }
}

