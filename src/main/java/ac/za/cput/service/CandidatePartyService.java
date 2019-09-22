package ac.za.cput.service;

import ac.za.cput.domain.CandidateParty;

import java.util.Set;

public interface CandidatePartyService {
    CandidateParty create(CandidateParty cp);
    CandidateParty update(CandidateParty cp);
    CandidateParty read(CandidateParty cp);
    boolean delete(CandidateParty cp);
    Set<CandidateParty> getAll();
}
