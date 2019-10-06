package ac.za.cput.service.impl;

import ac.za.cput.domain.CandidateParty;
import ac.za.cput.repository.CandidatePartyRep;
import ac.za.cput.service.CandidatePartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CandidatePartyServiceImpl implements CandidatePartyService {
    private static CandidatePartyService service = null;
    private static CandidatePartyService getService() {
        if(service == null) service = new CandidatePartyServiceImpl();
        return service;
    }

    @Autowired
    private CandidatePartyRep repository;

    private CandidatePartyServiceImpl() {
    }


    @Override
    public CandidateParty create(CandidateParty cp) {
        return this.repository.save(cp);
    }

    @Override
    public CandidateParty update(CandidateParty cp) {
        return this.repository.save(cp);
    }

    @Override
    public CandidateParty read(String s) {
        Optional<CandidateParty> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(CandidateParty s) {
        this.repository.delete(s);
    }


    @Override
    public List<CandidateParty> getAll() {
        return this.repository.findAll();
    }
}
