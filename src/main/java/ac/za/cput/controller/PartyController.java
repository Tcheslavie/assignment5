package ac.za.cput.controller;

import ac.za.cput.domain.*;
import ac.za.cput.service.PartyService;
import ac.za.cput.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/party")
public class PartyController {
    @Autowired
    @Qualifier("PartyServiceImpl")
    private PartyService service;

    @PostMapping("/create")
    @ResponseBody
    public Party create(Party u) {
        return service.create(u);
    }

    @PostMapping("/update")
    @ResponseBody
    public Party update(Party u) {
        return service.update(u);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Party read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Party> getAll() {
        return service.getAll();
    }
}
