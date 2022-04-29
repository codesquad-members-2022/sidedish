package com.team35.sidedish.repository;

import com.team35.sidedish.dto.auth.Provider;
import com.team35.sidedish.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByUserIdAndProvider(String userId, Provider provider);

    boolean existsByUserIdAndProvider(String userId, Provider provider);
}
