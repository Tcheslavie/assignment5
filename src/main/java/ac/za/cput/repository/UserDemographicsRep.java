package ac.za.cput.repository;

import ac.za.cput.domain.UserDemographics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserDemographicsRep extends JpaRepository<UserDemographics, String> {
}
