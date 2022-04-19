package codesquad.sidedish.domain.member;

import codesquad.sidedish.domain.address.District;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Member {
    private Long memberId;
    private String memberName;
    private District district;
    private int mileage;

    public Member(String memberName, District district) {
        this.memberName = memberName;
        this.district = district;
    }

    @Builder
    public Member(Long memberId, String memberName, District district, int mileage) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.district = district;
        this.mileage = mileage;
    }

    public boolean liveIn(District district) {
        return this.district == district;
    }

    public void initMemberId(Long memberId) {
        this.memberId = memberId;
    }


}
