package ac.za.cput.repository;

import ac.za.cput.domain.UserDemographics;

import java.util.Set;

public interface UserDemographicsRep extends RepInterface<UserDemographics, String> {
    Set<UserDemographics> getAll();
}
