package ac.za.cput.repository;

import ac.za.cput.domain.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PartyRepository extends JpaRepository<Party, String> {
}
