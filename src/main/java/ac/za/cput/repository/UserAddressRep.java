package ac.za.cput.repository;

import ac.za.cput.domain.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;
import java.util.Set;

public interface UserAddressRep extends JpaRepository<UserAddress, String> {
}
