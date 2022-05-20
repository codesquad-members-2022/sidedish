package com.sidedish.repository;

import com.sidedish.domain.user.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
