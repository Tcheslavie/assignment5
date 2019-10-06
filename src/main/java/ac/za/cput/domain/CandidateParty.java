package ac.za.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CandidateParty {
    @Id
    String candidateId;
    String partyId;

    private CandidateParty(){}
    public CandidateParty(String candidateId, String partyId) {
        this.candidateId = candidateId;
        this.partyId = partyId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
}
