package ac.za.cput.service.impl;

import ac.za.cput.domain.Candidate;
import ac.za.cput.repository.CandidateRep;
import ac.za.cput.repository.impl.CandidateRepImpl;
import ac.za.cput.service.CandidateService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CandidateServiceImpl implements CandidateService {
    private CandidateRep repository = null;
    private static CandidateService service = null;
    public static CandidateService getService() {
        if(service == null) service = new CandidateServiceImpl();
        return service;
    }
    private CandidateServiceImpl() {
        repository = CandidateRepImpl.getRepository();
    }


    @Override
    public Candidate create(Candidate candidate) {
        return repository.create(candidate);
    }

    @Override
    public Candidate update(Candidate candidate) {
        return repository.update(candidate);
    }

    @Override
    public boolean delete(String s) {
        return repository.delete(s);
    }

    @Override
    public Candidate read(String s) {
        return repository.read(s);
    }

    public Set<Candidate> getAll() {
        return repository.getAll();
    }

    public Candidate findByName(String s) {
        return this.getAll().stream().filter(c -> c.getName().toLowerCase().equals(s.toLowerCase())).findAny().orElse(null);
    }
}
