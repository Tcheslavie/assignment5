package ac.za.cput.repository;

import ac.za.cput.domain.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserContactRep extends JpaRepository<UserContact, String> {
}
