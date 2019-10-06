package ac.za.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAddress {
    @Id
    private String idnumber;
    private String addrLine1, addrLine2, city, province;
    private int postCode;

    private UserAddress(){};
    private UserAddress(Builder builder)
    {
        this.idnumber = builder.idnumber;
        this.addrLine1 = builder.addrLine1;
        this.addrLine2 = builder.addrLine2;
        this.city = builder.city;
        this.province = builder.province;
        this.postCode = builder.postCode;
    }

    public String getIdnumber(){
        return this.idnumber;
    }
    public String getAddrLine1() {return this.addrLine1;}

    public String getAddrLine2() {
        return addrLine2;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public int getPostCode() {
        return postCode;
    }

    public static class Builder{
        private String idnumber, addrLine1, addrLine2, city, province;
        private int postCode;

        public Builder idnumber(String idnumber)
        {
            this.idnumber = idnumber;
            return this;
        }

        public Builder addrLine1(String addr)
        {
            this.addrLine1 = addr;
            return this;
        }
        public Builder addrLine2(String addr)
        {
            this.addrLine2 = addr;
            return this;
        }
        public Builder city(String city)
        {
            this.city = city;
            return this;
        }
        public Builder province(String province)
        {
            this.province = province;
            return this;
        }
        public Builder postCode(int postCode)
        {
            this.postCode = postCode;
            return this;
        }

        public UserAddress build(){return new UserAddress(this);}
    }
}
