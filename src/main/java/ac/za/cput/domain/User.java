package ac.za.cput.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String idnumber,uname,lname;

    public String getIdnumber(){
        return this.idnumber;
    }
    public String getName(){
        return this.uname+" "+this.lname;
    }


    private User(){}

    private User(Builder builder)
    {
        this.idnumber = builder.idnumber;
        this.uname = builder.uname;
        this.lname = builder.lname;
    }
    public static class Builder{
        private String idnumber,uname,lname;

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


        public User build(){
            return new User(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getIdnumber(), user.getIdnumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdnumber());
    }
}
