package ac.za.cput.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String idnumber,uname,lname;
    private List<UserVoting> votingRecord;

    public String getIdnumber(){
        return this.idnumber;
    }
    public String getName(){
        return this.uname+" "+this.lname;
    }

    public List<UserVoting> getVotingRecord() {
        return votingRecord;
    }

    private User(){}

    private User(Builder builder)
    {
        this.votingRecord = new ArrayList<>();
        this.idnumber = builder.idnumber;
        this.uname = builder.uname;
        this.lname = builder.lname;
        this.votingRecord = builder.votingRecord;
    }
    public static class Builder{
        private String idnumber,uname,lname;
        private List<UserVoting> votingRecord = new ArrayList<>();

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

        public Builder votingRecord(UserVoting...votingRecord)
        {
            for(UserVoting r: votingRecord)
                this.votingRecord.add(r);
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
