package ac.za.cput.service.impl;

import ac.za.cput.domain.Party;
import ac.za.cput.repository.PartyRepository;
import ac.za.cput.repository.impl.PartyRepImpl;
import ac.za.cput.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("PartyServiceImpl")
public class PartyServiceImpl implements PartyService {

    @Autowired
    @Qualifier("PartyRep")
    private PartyRepository repository;

    @Override
    public Set<Party> getAll() {
        return this.repository.getAll();
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
        return this.repository.create(party);
    }

    @Override
    public Party update(Party party) {
        return this.repository.update(party);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public Party read(String s) {
        return this.repository.read(s);
    }
}
