package ac.za.cput.service.impl;

import ac.za.cput.domain.CandidateParty;
import ac.za.cput.repository.CandidatePartyRep;
import ac.za.cput.repository.impl.CandidatePartyRepImpl;
import ac.za.cput.service.CandidatePartyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CandidatePartyServiceImpl implements CandidatePartyService {
    private static CandidatePartyService service = null;
    private static CandidatePartyService getService() {
        if(service == null) service = new CandidatePartyServiceImpl();
        return service;
    }

    private CandidatePartyRep repository;

    private CandidatePartyServiceImpl() {
        this.repository = CandidatePartyRepImpl.getRepository();
    }


    @Override
    public CandidateParty create(CandidateParty cp) {
        return this.repository.create(cp);
    }

    @Override
    public CandidateParty update(CandidateParty cp) {
        return this.repository.update(cp);
    }

    @Override
    public CandidateParty read(CandidateParty cp) {
        return this.repository.read(cp);
    }

    @Override
    public boolean delete(CandidateParty cp) {
        return this.repository.delete(cp);
    }

    @Override
    public Set<CandidateParty> getAll() {
        return this.repository.getAll();
    }

}
