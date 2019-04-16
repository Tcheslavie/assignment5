package ac.za.cput.factory;

import ac.za.cput.domain.UserVoting;

public class UserVotingFactory {
    public static UserVoting getUserVoting(String idnumber, int year, int candidate)
    {
        return new UserVoting.Builder().idnumber(idnumber).year(year).candidateId(candidate).build();
    }
}
