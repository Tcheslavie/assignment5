package ac.za.cput.domain;

import java.util.ArrayList;
import java.util.List;

public class Election {
    private int year;
    private List<Candidate> candidates;

    private Election(){}
    private Election(Builder builder)
    {
        candidates = new ArrayList<>();
        this.year = builder.year;
        this.candidates = builder.candidates;
    }

    public int getYear() {
        return year;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public static class Builder
    {
        private int year;
        private List<Candidate> candidates = new ArrayList<>();

        public Builder year (int year)
        {
            this.year = year;
            return this;
        }
        public Builder candidates(Candidate...candidates)
        {
            for(Candidate c: candidates)
                this.candidates.add(c);
            return this;
        }
        public Election build()
        {
            return new Election(this);
        }
    }
}
