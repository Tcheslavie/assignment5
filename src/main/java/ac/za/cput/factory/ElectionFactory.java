package ac.za.cput.factory;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.Election;

public class ElectionFactory {
    public static Election getElection(int year)
    {
        return new Election.Builder().year(year).build();
    }
}
