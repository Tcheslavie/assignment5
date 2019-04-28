package ac.za.cput.domain;

public class Candidate {
    private String candidateId, partyId;
    private String fname, lname;

    private Candidate(){}
    private Candidate(Builder builder)
    {
        this.candidateId = builder.candidateId;
        this.fname = builder.fname;
        this.lname = builder.lname;
        this.partyId = builder.partyId;
    }
    public String getCandidateId(){
        return this.candidateId;
    }
    public String getName(){
        return this.fname+" "+this.lname;
    }
    public String getPartyId()
    {
        return this.partyId;
    }

    public static class Builder
    {
        private String candidateId, partyId;
        private String fname, lname;

        public Builder candidateId(String candidateId)
        {
            this.candidateId = candidateId;
            return this;
        }
        public Builder fname(String fname){
            this.fname = fname;
            return this;
        }
        public Builder lname(String lname){
            this.lname = lname;
            return this;
        }
        public Builder partyId(String partyId){
            this.partyId = partyId;
            return this;
        }

        public Candidate build(){
            return new Candidate(this);
        }
    }
}
