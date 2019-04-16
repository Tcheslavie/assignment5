package ac.za.cput.domain;

public class UserDemographics {
    private String idnumber, gender, race;

    private UserDemographics(){}
    private UserDemographics(Builder builder)
    {
        this.idnumber = builder.idnumber;
        this.gender = builder.gender;
        this.race = builder.race;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public static class Builder{
        private String idnumber, gender, race;

        public Builder idnumber(String idnumber)
        {
            this.idnumber = idnumber;
            return this;
        }
        public Builder gender(String gender)
        {
            this.gender = gender;
            return this;
        }
        public Builder race(String race)
        {
            this.idnumber = race;
            return this;
        }
        public UserDemographics build()
        {
            return new UserDemographics(this);
        }
    }
}
