package ac.za.cput.repository;

import ac.za.cput.domain.CandidateParty;

import java.util.Set;

public interface CandidatePartyRep {
    CandidateParty create(CandidateParty cp);
    CandidateParty update(CandidateParty cp);
    CandidateParty read(CandidateParty cp);
    boolean delete(CandidateParty cp);
    Set<CandidateParty> getAll();

}
