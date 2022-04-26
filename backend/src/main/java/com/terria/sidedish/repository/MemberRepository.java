package com.terria.sidedish.repository;


import com.terria.sidedish.domain.Member;
import com.terria.sidedish.dto.auth.Provider;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByUserIdAndProvider(String userId, Provider provider);

    boolean existsByUserIdAndProvider(String userId, Provider provider);
}
