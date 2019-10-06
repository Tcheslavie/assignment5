package ac.za.cput.repository;

import ac.za.cput.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {
}
