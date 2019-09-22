package ac.za.cput.domain;

public class CandidateElection {
    private int year, candidateId;

    private CandidateElection(){}
    private CandidateElection(Builder builder){
        this.year = builder.year;
        this.candidateId=builder.candidateId;
    }

    public int getYear() {
        return year;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public static class Builder{
        private int year, candidateId;

        public Builder year(int year)
        {
            this.year = year;
            return this;
        }
        public Builder candidateId(int candidateId)
        {
            this.candidateId = candidateId;
            return this;
        }
        public CandidateElection build()
        {
            return new CandidateElection(this);
        }
    }
}
