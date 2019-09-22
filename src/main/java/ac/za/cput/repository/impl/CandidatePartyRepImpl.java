package ac.za.cput.repository.impl;

import ac.za.cput.domain.CandidateParty;
import ac.za.cput.repository.CandidatePartyRep;

import java.util.HashSet;
import java.util.Set;

public class CandidatePartyRepImpl implements CandidatePartyRep {
    private static CandidatePartyRep repository = null;
    private Set<CandidateParty> cps;
    private CandidatePartyRepImpl() {
        cps = new HashSet<>();
    }

    public static CandidatePartyRep getRepository() {
        if(repository==null) repository = new CandidatePartyRepImpl();
        return repository;
    }

    @Override
    public CandidateParty create(CandidateParty candidateParty) {
        this.cps.add(candidateParty);
        return candidateParty;
    }

    @Override
    public CandidateParty update(CandidateParty cp) {
        CandidateParty c = this.read(cp);
        if(c != null) {
            this.delete(c);
            return this.create(cp);
        }
        return null;
    }

    @Override
    public CandidateParty read(CandidateParty cp) {
        return cps.stream().filter(c -> c.getCandidateId().equals(cp.getCandidateId().trim())).findAny().orElse(null);
    }

    @Override
    public boolean delete(CandidateParty cp) {
        CandidateParty c = this.read(cp);
        if(c != null) {
            cps.remove(c);
            return true;
        }
        return false;
    }

    @Override
    public Set<CandidateParty> getAll() {
        return cps;
    }


}
