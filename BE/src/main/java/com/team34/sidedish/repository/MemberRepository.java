package com.team34.sidedish.repository;

import com.team34.sidedish.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

}
