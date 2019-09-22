package ac.za.cput.factory;

import ac.za.cput.domain.Candidate;
import ac.za.cput.util.Misc;

public class CandidateFactory {
    public static Candidate getCandidate(String fname, String lname)
    {
        return new Candidate.Builder().candidateId(Misc.randomUUID()).fname(fname).lname(lname).build();
    }
}
