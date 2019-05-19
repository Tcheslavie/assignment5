package ac.za.cput.repository.impl;

import ac.za.cput.domain.UserDemographics;
import ac.za.cput.repository.UserDemographicsRep;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("UserDemographicsRep")
public class UserDemographicsRepImpl implements UserDemographicsRep {
    private static UserDemographicsRep repository = null;
    private Set<UserDemographics> udemos;

    private UserDemographicsRepImpl()
    {
        udemos = new HashSet<>();
    }

    public static UserDemographicsRep getRepository()
    {
        if(repository==null) repository = new UserDemographicsRepImpl();
        return repository;
    }

    @Override
    public Set<UserDemographics> getAll() {
        return this.udemos;
    }

    @Override
    public UserDemographics create(UserDemographics userDemographics) {
        this.udemos.add(userDemographics);
        return userDemographics;
    }

    @Override
    public UserDemographics update(UserDemographics userDemographics) {
        for(UserDemographics ud : this.udemos)
        {
            if(ud.getIdnumber().equals(userDemographics.getIdnumber()))
            {
                this.udemos.remove(ud);
                this.udemos.add(userDemographics);
                return userDemographics;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        for(UserDemographics ud:this.udemos)
        {
            if(ud.getIdnumber().equals(s))
            {
                this.udemos.remove(ud);
                return true;
            }
        }
        return false;
    }

    @Override
    public UserDemographics read(String s) {
        for(UserDemographics ud : this.udemos)
        {
            if(ud.getIdnumber().equals(s))
            {
                return ud;
            }
        }
        return null;
    }
}
