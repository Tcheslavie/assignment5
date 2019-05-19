package ac.za.cput.service.impl;

import ac.za.cput.domain.UserDemographics;
import ac.za.cput.repository.UserDemographicsRep;
import ac.za.cput.repository.impl.UserDemographicsRepImpl;
import ac.za.cput.service.UserDemographicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("UserDemographicsServiceImpl")
public class UserDemographicsServiceImpl implements UserDemographicsService {

    @Autowired
    @Qualifier("UserDemographicsRep")
    private UserDemographicsRep repository;

    @Override
    public Set<UserDemographics> getAll() {
        return this.repository.getAll();
    }

    @Override
    public UserDemographics create(UserDemographics userDemographics) {
        return this.repository.create(userDemographics);
    }

    @Override
    public UserDemographics update(UserDemographics userDemographics) {
        return this.repository.update(userDemographics);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public UserDemographics read(String s) {
        return this.repository.read(s);
    }
}
