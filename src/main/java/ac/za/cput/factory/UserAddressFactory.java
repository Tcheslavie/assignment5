package ac.za.cput.factory;


import ac.za.cput.domain.UserAddress;

public class UserAddressFactory {
    public static UserAddress getUserAddress(String idnumber, String adr1, String adr2, String city, String province, int postCode)
    {
        return new UserAddress.Builder().idnumber(idnumber).addrLine1(adr1).addrLine2(adr2).city(city).province(province).postCode(postCode).build();
    }
}
