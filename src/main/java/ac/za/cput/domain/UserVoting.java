package ac.za.cput.domain;

public class UserVoting {
    private String idnumber;
    private int year, candidateId;

    private UserVoting(){}
    private UserVoting(Builder builder)
    {
        this.idnumber = builder.idnumber;
        this.year = builder.year;
        this.candidateId = builder.candidateId;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public int getYear() {
        return year;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public static class Builder {
        private String idnumber;
        private int year, candidateId;

        public Builder idnumber(String idnumber)
        {
            this.idnumber = idnumber;
            return this;
        }
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

        public UserVoting build()
        {
            return new UserVoting(this);
        }
    }
}
