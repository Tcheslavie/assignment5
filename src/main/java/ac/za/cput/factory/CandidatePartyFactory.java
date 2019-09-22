package ac.za.cput.factory;

import ac.za.cput.domain.CandidateParty;

public class CandidatePartyFactory {
    public static CandidateParty getCandidateParty(String candidateId, String partyId) {
        return new CandidateParty(candidateId, partyId);
    }
}
