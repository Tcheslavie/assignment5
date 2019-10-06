package ac.za.cput.service;

import ac.za.cput.domain.CandidateParty;

import java.util.List;
import java.util.Set;

public interface CandidatePartyService extends ServiceInterface<CandidateParty, String>{
    List<CandidateParty> getAll();
}
