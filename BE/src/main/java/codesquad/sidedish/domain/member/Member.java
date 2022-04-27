package codesquad.sidedish.domain.member;

import codesquad.sidedish.domain.address.Address;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Member {
    private Long memberId;
    private String memberName;
    private Address address;
    private int mileage;

    public Member(String memberName, Address address) {
        this.memberName = memberName;
        this.address = address;
    }

    @Builder
    public Member(Long memberId, String memberName, Address address, int mileage) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.address = address;
        this.mileage = mileage;
    }

    public boolean liveIn(String district) {
        return address.getDistrict().equals(district);
    }

    public void initMemberId(Long memberId) {
        this.memberId = memberId;
    }


}
