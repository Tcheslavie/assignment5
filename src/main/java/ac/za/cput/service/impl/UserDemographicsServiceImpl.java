package ac.za.cput.service.impl;

import ac.za.cput.domain.UserDemographics;
import ac.za.cput.repository.UserDemographicsRep;
import ac.za.cput.service.UserDemographicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDemographicsServiceImpl implements UserDemographicsService {

    @Autowired
    private UserDemographicsRep repository;

    @Override
    public List<UserDemographics> getAll() {
        return this.repository.findAll();
    }

    @Override
    public UserDemographics create(UserDemographics userDemographics) {
        return this.repository.save(userDemographics);
    }

    @Override
    public UserDemographics update(UserDemographics userDemographics) {
        return this.repository.save(userDemographics);
    }

    @Override
    public void delete(UserDemographics s) {
        this.repository.delete(s);
    }

    @Override
    public UserDemographics read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
