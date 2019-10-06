package ac.za.cput.service.impl;

import ac.za.cput.domain.Candidate;
import ac.za.cput.domain.CandidateParty;
import ac.za.cput.repository.CandidateRep;
import ac.za.cput.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRep repository;
    private static CandidateService service = null;
    public static CandidateService getService() {
        if(service == null) service = new CandidateServiceImpl();
        return service;
    }
    private CandidateServiceImpl() {

    }


    @Override
    public Candidate create(Candidate candidate) {
        return repository.save(candidate);
    }

    @Override
    public Candidate update(Candidate candidate) {
        return repository.save(candidate);
    }

    @Override
    public void delete(Candidate s) {
        repository.delete(s);
    }

    @Override
    public Candidate read(String s) {
        Optional<Candidate> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    public List<Candidate> getAll() {
        return repository.findAll();
    }

    public Candidate findByName(String s) {
        for(Candidate c : this.getAll()) {
            if(c.getName().equals(s)) {
                return c;
            }
        }
        return null;
    }
}
