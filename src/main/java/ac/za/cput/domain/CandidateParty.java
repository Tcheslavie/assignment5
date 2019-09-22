package ac.za.cput.domain;

public class CandidateParty {
    String candidateId;
    String partyId;

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
