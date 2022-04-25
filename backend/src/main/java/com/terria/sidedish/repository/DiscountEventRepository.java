package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.reference.DiscountEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscountEventRepository extends CrudRepository<DiscountEvent, Long> {

    Optional<DiscountEvent> findById(long id);
}
