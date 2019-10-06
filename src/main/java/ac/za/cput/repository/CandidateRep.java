package ac.za.cput.repository;

import ac.za.cput.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CandidateRep extends JpaRepository<Candidate, String> {
}
