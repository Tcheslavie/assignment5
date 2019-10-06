package ac.za.cput.service.impl;

import ac.za.cput.domain.Party;
import ac.za.cput.repository.PartyRepository;
import ac.za.cput.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class PartyServiceImpl implements PartyService {

    @Autowired
    private PartyRepository repository;

    @Override
    public List<Party> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Party findByName(String party) {

        for (Party p : this.getAll()) {
            if (p.getName().equals(party)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Party create(Party party) {
        return this.repository.save(party);
    }

    @Override
    public Party update(Party party) {
        return this.repository.save(party);
    }

    @Override
    public void delete(Party s) {
        this.repository.delete(s);
    }

    @Override
    public Party read(String s) {

        Optional<Party> opt = this.repository.findById(s);
        return opt.orElse(null);
    }
}
