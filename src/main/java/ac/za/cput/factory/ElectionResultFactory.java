package ac.za.cput.factory;

import ac.za.cput.domain.ElectionResult;

public class ElectionResultFactory {
    public static ElectionResult getElectionResult(int year, int candidateId)
    {
        return new ElectionResult.Builder().year(year).candidateId(candidateId).build();
    }
}
