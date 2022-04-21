package codesquad.sidedish.domain.address;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Address {
    private String district;
    private String city;

    public Address(String district, String city) {
        this.district = district;
        this.city = city;
    }


}
