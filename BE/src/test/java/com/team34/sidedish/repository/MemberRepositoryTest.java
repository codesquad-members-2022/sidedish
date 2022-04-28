package com.team34.sidedish.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.team34.sidedish.domain.Member;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void findById() {
        Optional<Member> member = memberRepository.findById(1L);
        assertThat(member).isNotEmpty()
            .get()
            .hasFieldOrPropertyWithValue("name", "dave");
    }
}
