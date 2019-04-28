package ac.za.cput.repository;

import ac.za.cput.domain.User;

import java.util.Set;

public interface UserRepository extends RepInterface<User, String> {
    public Set<User> getAll();
}
