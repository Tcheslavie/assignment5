package ac.za.cput.factory;

import ac.za.cput.domain.Candidate;

public class CandidateFactory {
    public static Candidate getCandidate(int candidateId, String fname, String lname, int partyId)
    {
        return new Candidate.Builder().candidateId(candidateId).fname(fname).lname(lname).partyId(partyId).build();
    }
}
