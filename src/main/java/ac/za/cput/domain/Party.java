package ac.za.cput.domain;

public class Party {
    private int partyId;
    private String name;

    private Party(){}
    private Party(Builder builder)
    {
        this.partyId = builder.partyId;
        this.name = builder.name;
    }

    public static class Builder{
        private int partyId;
        private String name;

        public Builder(int partyId)
        {
            this.partyId=partyId;
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
}
