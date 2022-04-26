package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.reference.DiscountEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DiscountEventRepository extends CrudRepository<DiscountEvent, Long> {

    Optional<DiscountEvent> findById(long id);
}
