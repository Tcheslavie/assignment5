package ac.za.cput.repository;

import ac.za.cput.domain.CandidateParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CandidatePartyRep extends JpaRepository<CandidateParty, String> {

}
