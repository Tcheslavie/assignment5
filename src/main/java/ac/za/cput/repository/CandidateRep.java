package ac.za.cput.repository;

import ac.za.cput.domain.Candidate;

import java.util.Set;

public interface CandidateRep extends RepInterface<Candidate, String> {
    Set<Candidate> getAll();
}
