package ac.za.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CandidateElection {
    private int year;
    @Id
    private String candidateId;

    private CandidateElection(){}
    private CandidateElection(Builder builder){
        this.year = builder.year;
        this.candidateId=builder.candidateId;
    }

    public int getYear() {
        return year;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public static class Builder{
        private int year;
        private String candidateId;

        public Builder year(int year)
        {
            this.year = year;
            return this;
        }
        public Builder candidateId(String candidateId)
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
