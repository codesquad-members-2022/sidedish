package codesquad.sidedish.domain.member;

import codesquad.sidedish.domain.address.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.as;
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
        Member saveMember = new Member("sampleName", new Address("서울특별시", "강남구"));
        Long memberId = memberRepository.save(saveMember);
        log.info("saveMember = {}", saveMember);
        Member findMember = memberRepository.findById(memberId).get();
        log.info("findMember = {}", findMember);

        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    @DisplayName("update() 메서드를 회원 정보를 갱신한 뒤, findById() 메서드로 조회하면 갱신된 회원이 반환되어야한다.")
    public void updateTest() {
        //given
        Member saveMember = new Member("sampleName", new Address("서울특별시", "강남구"));
        memberRepository.save(saveMember);
        log.info("SaveMember Mileage = {}", saveMember.getMileage());

        Member updateMember = memberRepository.findById(saveMember.getMemberId()).get();
        log.info("UpdateMember Before Earn Mileage = {}", updateMember.getMileage());
        updateMember.earnMileage(100);
        log.info("UpdateMember After Earn Mileage = {}", updateMember.getMileage());
        memberRepository.update(updateMember);

        Member findMember = memberRepository.findById(saveMember.getMemberId()).get();
        log.info("findMember Mileage = {}", findMember.getMileage());
        assertThat(findMember.getMileage()).isEqualTo(100);
    }
}
