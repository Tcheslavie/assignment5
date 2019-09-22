package ac.za.cput.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Party {
    private String partyId;
    private String name;

    public String getPartyId() {
        return partyId;
    }

    public String getName() {
        return name;
    }


    private Party(){}
    private Party(Builder builder)
    {
        this.partyId = builder.partyId;
        this.name = builder.name;
    }

    public static class Builder{
        private String partyId;
        private String name;

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
