package ac.za.cput.factory;

import ac.za.cput.domain.CandidateElection;

public class CandidateElectionFactory {
    public static CandidateElection getElectionResult(int year, int candidateId)
    {
        return new CandidateElection.Builder().year(year).candidateId(candidateId).build();
    }
}
