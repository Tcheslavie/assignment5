package ac.za.cput.domain;

public class UserContact {
    private String idNumber, cellPhone, workPhone, homePhone;

    private UserContact(){};
    private UserContact(Builder builder)
    {
        this.idNumber = builder.idNumber;
        this.cellPhone = builder.cellPhone;
        this.workPhone = builder.workPhone;
        this.homePhone = builder.homePhone;
    }
    public String getIdNumber() { return idNumber; }
    public String getCellPhone() {
        return cellPhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public static class Builder
    {
        private String idNumber, cellPhone, workPhone, homePhone;
        public Builder idNumber(String idNumber)
        {
            this.idNumber = idNumber;
            return this;
        }
        public Builder cellPhone(String cellPhone)
        {
            this.cellPhone = cellPhone;
            return this;
        }
        public Builder workPhone(String workPhone)
        {
            this.workPhone = workPhone;
            return this;
        }
        public Builder homePhone(String homePhone)
        {
            this.homePhone = homePhone;
            return this;
        }

        public UserContact build()
        {
            return new UserContact(this);
        }
    }
}
