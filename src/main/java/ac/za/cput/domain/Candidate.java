package ac.za.cput.domain;

public class Candidate {
    private String candidateId;
    private String fname, lname;

    private Candidate(){}
    private Candidate(Builder builder)
    {
        this.candidateId = builder.candidateId;
        this.fname = builder.fname;
        this.lname = builder.lname;
    }
    public String getCandidateId(){
        return this.candidateId;
    }
    public String getName(){
        return this.fname+" "+this.lname;
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

        public Candidate build(){
            return new Candidate(this);
        }
    }
}
