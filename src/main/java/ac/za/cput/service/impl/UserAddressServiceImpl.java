package ac.za.cput.service.impl;

import ac.za.cput.domain.UserAddress;
import ac.za.cput.repository.UserAddressRep;
import ac.za.cput.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressRep repository;

    @Override
    public List<UserAddress> getAll() {
        return this.repository.findAll();
    }

    @Override
    public UserAddress create(UserAddress userAddress) {
        return this.repository.save(userAddress);
    }

    @Override
    public UserAddress update(UserAddress userAddress) {
        return this.repository.save(userAddress);
    }

    @Override
    public void delete(UserAddress s) {
        this.repository.delete(s);
    }

    @Override
    public UserAddress read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
