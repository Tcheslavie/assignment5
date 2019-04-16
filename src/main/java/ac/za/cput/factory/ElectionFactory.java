package ac.za.cput.factory;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.Election;

public class ElectionFactory {
    public static Election getElection(int year, Candidate...candidates)
    {
        return new Election.Builder().year(year).candidates(candidates).build();
    }
}
