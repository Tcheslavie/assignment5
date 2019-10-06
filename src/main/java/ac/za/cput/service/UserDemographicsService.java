package ac.za.cput.service;

import ac.za.cput.domain.UserDemographics;

import java.util.List;
import java.util.Set;

public interface UserDemographicsService extends ServiceInterface<UserDemographics, String> {
    List<UserDemographics> getAll();
}
