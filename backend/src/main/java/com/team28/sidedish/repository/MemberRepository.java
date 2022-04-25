package com.team28.sidedish.repository;

import com.team28.sidedish.repository.entity.MemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<MemberEntity, Long> {
}
