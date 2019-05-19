package ac.za.cput.repository.impl;

import ac.za.cput.domain.UserAddress;
import ac.za.cput.repository.UserAddressRep;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("UserAddressRep")
public class UserAddressRepImpl implements UserAddressRep {
    private static UserAddressRep repository = null;
    private Set<UserAddress> addresses;

    private UserAddressRepImpl()
    {
        this.addresses = new HashSet<>();
    }
    public static UserAddressRep getRepository()
    {
        if(repository==null) repository = new UserAddressRepImpl();
        return repository;
    }

    @Override
    public UserAddress create(UserAddress userAddress) {
        this.addresses.add(userAddress);
        return userAddress;
    }

    @Override
    public UserAddress update(UserAddress userAddress) {
        String id = userAddress.getIdnumber();
        for(UserAddress addr : addresses)
        {
            if(addr.getIdnumber().equals(id))
            {
                this.addresses.remove(addr);
                this.addresses.add(userAddress);
                return  userAddress;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        for(UserAddress addr : addresses)
        {
            if(addr.getIdnumber().equals(s))
            {
                this.addresses.remove(addr);
                return true;
            }
        }
        return false;
    }

    @Override
    public UserAddress read(String s) {
        for(UserAddress addr : addresses)
        {
            if(addr.getIdnumber().equals(s))
            {
                return addr;
            }
        }
        return null;
    }


    @Override
    public Set<UserAddress> getAll() {
        return this.addresses;
    }
}
