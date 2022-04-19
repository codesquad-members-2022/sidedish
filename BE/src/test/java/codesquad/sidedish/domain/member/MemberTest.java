package codesquad.sidedish.domain.member;

import codesquad.sidedish.domain.address.District;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Member 클래스의")
class MemberTest {

    @Test
    @DisplayName("liveIn 메서드는 같은 지역인지 여부를 판단해야 한다.")
    void liveInTest() {
        Member member = new Member("sampleName", District.SEOUL);
        assertThat(member.liveIn(District.SEOUL)).isTrue();
        assertThat(member.liveIn(District.BUSAN)).isFalse();
    }
}