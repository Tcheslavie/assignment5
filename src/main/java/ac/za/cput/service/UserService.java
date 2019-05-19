package ac.za.cput.service;

import ac.za.cput.domain.User;

import java.util.Set;

public interface UserService extends ServiceInterface<User, String> {
    public Set<User> getAll();
}
