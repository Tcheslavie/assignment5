package ac.za.cput.repository;

import ac.za.cput.domain.UserAddress;

import javax.jws.soap.SOAPBinding;
import java.util.Set;

public interface UserAddressRep extends RepInterface<UserAddress, String> {
    Set<UserAddress> getAll();
}
