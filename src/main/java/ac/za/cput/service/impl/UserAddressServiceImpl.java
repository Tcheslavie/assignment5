package ac.za.cput.service.impl;

import ac.za.cput.domain.UserAddress;
import ac.za.cput.repository.UserAddressRep;
import ac.za.cput.repository.impl.UserAddressRepImpl;
import ac.za.cput.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("UserAddressServiceImpl")
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    @Qualifier("UserAddressRep")
    private UserAddressRep repository;

    @Override
    public Set<UserAddress> getAll() {
        return this.repository.getAll();
    }

    @Override
    public UserAddress create(UserAddress userAddress) {
        return this.repository.create(userAddress);
    }

    @Override
    public UserAddress update(UserAddress userAddress) {
        return this.repository.update(userAddress);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public UserAddress read(String s) {
        return this.repository.read(s);
    }
}
