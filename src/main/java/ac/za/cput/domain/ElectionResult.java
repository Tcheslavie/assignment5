package ac.za.cput.domain;

public class ElectionResult {
    private int year, candidateId;

    private ElectionResult(){}
    private ElectionResult(Builder builder){
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
        public ElectionResult build()
        {
            return new ElectionResult(this);
        }
    }
}
