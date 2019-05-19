package ac.za.cput.repository;

import ac.za.cput.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface UserRepository extends RepInterface<User, String> {
    public Set<User> getAll();
}
