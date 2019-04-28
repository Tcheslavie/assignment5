package ac.za.cput.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Party {
    private String partyId;
    private String name;
    private List<Candidate> candidates;

    public String getPartyId() {
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
        private String partyId;
        private String name;
        private List<Candidate> candidates = new ArrayList<>();

        public Builder partyId(String partyId)
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
            if(candidates!=null)
                for(Candidate c: candidates)
                    this.candidates.add(c);
            return this;
        }
        public Party build(){
            return new Party(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Party)) return false;
        Party party = (Party) o;
        return getPartyId() == party.getPartyId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPartyId(), getName());
    }
}
