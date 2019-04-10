package ac.za.cput.domain;

public class User {
    private String idnumber;
    private String uname;
    private String lname;
    private String address;
    private int phone;
    private boolean hasVoted;

    public String getIdnumber(){
        return this.idnumber;
    }
    public String getName(){
        return this.uname+" "+this.lname;
    }
    public String getAddress()
    {
        return this.address;
    }
    public int getPhone(){
        return this.phone;
    }
    public boolean getVoted()
    {
        return this.hasVoted;
    }
    private User(){}

    private User(Builder builder)
    {
        this.idnumber = builder.idnumber;
        this.uname = builder.uname;
        this.lname = builder.lname;
        this.address = builder.address;
        this.phone = builder.phone;
        this.hasVoted = builder.hasVoted;
    }
    public static class Builder{
        private String idnumber;
        private String uname;
        private String lname;
        private String address;
        private int phone;
        private boolean hasVoted;


        public Builder idnumber(String idnumber){
            this.idnumber = idnumber;
            return this;
        }
        public Builder uname(String uname){
            this.uname = uname;
            return this;
        }

        public Builder lname(String lname){
            this.lname = lname;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder phone(int phone){
            this.phone = phone;
            return this;
        }

        public Builder hasVoted(boolean hasVoted){
            this.hasVoted = hasVoted;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
