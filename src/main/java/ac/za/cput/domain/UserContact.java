package ac.za.cput.domain;

public class UserContact {
    private String cellPhone, workPhone, homePhone;

    private UserContact(){};
    private UserContact(Builder builder)
    {
        this.cellPhone = builder.cellPhone;
        this.workPhone = builder.workPhone;
        this.homePhone = builder.homePhone;
    }

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
        private String cellPhone, workPhone, homePhone;

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
