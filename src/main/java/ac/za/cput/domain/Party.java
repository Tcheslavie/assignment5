package ac.za.cput.domain;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private int partyId;
    private String name;
    private List<Candidate> candidates;

    public int getPartyId() {
        return partyId;
    }

    public String getName() {
        return name;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    private Party(){}
    private Party(Builder builder)
    {
        candidates = new ArrayList<>();

        this.partyId = builder.partyId;
        this.name = builder.name;
        this.candidates = builder.candidates;
    }

    public static class Builder{
        private int partyId;
        private String name;
        private List<Candidate> candidates = new ArrayList<>();

        public Builder partyId(int partyId)
        {
            this.partyId = partyId;
            return this;
        }
        public Builder name (String name)
        {
            this.name = name;
            return this;
        }
        public Builder candidates(Candidate...candidates)
        {
            for(Candidate c: candidates)
                this.candidates.add(c);
            return this;
        }
        public Party build(){
            return new Party(this);
        }
    }
}
