package codesquad.sidedish.domain.member;

import codesquad.sidedish.domain.address.Address;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Member 클래스의")
class MemberTest {

    @Test
    @DisplayName("liveIn 메서드는 같은 지역인지 여부를 판단해야 한다.")
    void liveInTest() {
        Member member = new Member("sampleName", new Address("서울특별시", "강남구"));
        assertThat(member.liveIn("서울특별시")).isTrue();
        assertThat(member.liveIn("부산광역시")).isFalse();
    }
}