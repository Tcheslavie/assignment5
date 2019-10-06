package ac.za.cput.controller;

import ac.za.cput.domain.User;
import ac.za.cput.domain.UserAddress;
import ac.za.cput.domain.UserContact;
import ac.za.cput.domain.UserDemographics;
import ac.za.cput.factory.UserAddressFactory;
import ac.za.cput.service.UserAddressService;
import ac.za.cput.service.UserContactService;
import ac.za.cput.service.UserDemographicsService;
import ac.za.cput.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private UserAddressService addressService;
    @Autowired
    private UserContactService contactService;
    @Autowired
    private UserDemographicsService demographService;

    @PostMapping("/create")
    @ResponseBody
    public User create(User u) {
        addressService.create(new UserAddress.Builder().idnumber(u.getIdnumber()).build());
        contactService.create(new UserContact.Builder().idNumber(u.getIdnumber()).build());
        demographService.create(new UserDemographics.Builder().idnumber(u.getIdnumber()).build());
        return service.create(u);
    }

    @PostMapping("/update")
    @ResponseBody
    public User update(User u) {
        return service.update(u);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        User u = service.read(id);
        if(u != null) service.delete(u);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public User read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/read/address/{id}")
    @ResponseBody
    public UserAddress getAddr(@PathVariable String id)
    {
        return addressService.read(id);
    }

    @GetMapping("/read/address/update/{id}")
    @ResponseBody
    public UserAddress updAddr(UserAddress u)
    {
        return addressService.update(u);
    }

    @GetMapping("/read/contact/{id}")
    @ResponseBody
    public UserContact getContact(@PathVariable String id)
    {
        return contactService.read(id);
    }
    @GetMapping("/read/contact/update/{id}")
    @ResponseBody
    public UserContact updContact(UserContact u)
    {
        return contactService.update(u);
    }
    @GetMapping("/read/demographics/{id}")
    @ResponseBody
    public UserDemographics getDemograph(@PathVariable String id)
    {
        return demographService.read(id);
    }
    @GetMapping("/read/demographics/update/{id}")
    @ResponseBody
    public UserDemographics updDemograph(UserDemographics u)
    {
        return demographService.update(u);
    }
}
