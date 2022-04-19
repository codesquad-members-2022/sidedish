package codesquad.sidedish.domain.member;

import codesquad.sidedish.domain.address.District;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
@Transactional
@SpringBootTest
@DisplayName("MemberRepository의")
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("save() 메서드로 회원을 저장한 후, findById() 메서드로 조회하면 같은 회원이 반환되어야 한다.")
    void saveTest() {
        Member saveMember = new Member("sampleName", District.SEOUL);
        Long memberId = memberRepository.save(saveMember);
        log.info("saveMember = {}", saveMember);
        Member findMember = memberRepository.findById(memberId).get();
        log.info("findMember = {}", findMember);

        assertThat(findMember).isEqualTo(saveMember);
    }


}