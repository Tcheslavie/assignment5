package ac.za.cput.factory;

import ac.za.cput.domain.UserDemographics;

public class UserDemographicsFactory {
    public static UserDemographics getUserDemographics(String idnumber, String gender, String race)
    {
        return new UserDemographics.Builder().idnumber(idnumber).gender(gender).race(race).build();
    }
}
