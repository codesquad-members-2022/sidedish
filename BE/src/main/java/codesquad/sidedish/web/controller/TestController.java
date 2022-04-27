package codesquad.sidedish.web.controller;

import codesquad.sidedish.domain.address.Address;
import codesquad.sidedish.domain.member.Member;
import codesquad.sidedish.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final MemberRepository memberRepository;

    @GetMapping
    public Member testMethod() {
        Member sampleMember = new Member("sampleName", new Address("부산광역시", "서구"));
        Long saveId = memberRepository.save(sampleMember);
        log.info("saveId = {}", saveId);
        return memberRepository.findById(saveId).get();
    }
}
