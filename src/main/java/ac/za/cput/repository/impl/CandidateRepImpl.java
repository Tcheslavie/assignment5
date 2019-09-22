package ac.za.cput.repository.impl;

import ac.za.cput.domain.Candidate;
import ac.za.cput.repository.CandidateRep;

import java.util.HashSet;
import java.util.Set;

public class CandidateRepImpl implements CandidateRep {
    private Set<Candidate> candidates;
    private static CandidateRep repository = null;
    public static CandidateRep getRepository() {
        if(repository == null) repository = new CandidateRepImpl();
        return repository;
    }
    private CandidateRepImpl() {
        candidates = new HashSet<>();
    }


    @Override
    public Candidate create(Candidate candidate) {
        candidates.add(candidate);
        return candidate;
    }

    @Override
    public Candidate update(Candidate candidate) {
        Candidate c = read(candidate.getCandidateId());
        if(c != null) {
            delete(candidate.getCandidateId());
            return create(candidate);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Candidate del = read(s);
        if(del != null) {
            candidates.remove(del);
            return true;
        }
        return false;
    }

    @Override
    public Candidate read(String s) {
        return candidates.stream().filter(c -> c.getCandidateId().equals(s)).findAny().orElse(null);
    }

    @Override
    public Set<Candidate> getAll() {
        return candidates;
    }
}
