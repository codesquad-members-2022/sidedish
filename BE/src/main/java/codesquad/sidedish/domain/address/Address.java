package codesquad.sidedish.domain.address;

import lombok.Getter;

@Getter
public class Address {
    private String district;
    private String city;

    public Address(String district, String city) {
        this.district = district;
        this.city = city;
    }


}
