package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.reference.SideDish;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SideDishRepository extends CrudRepository<SideDish, Long> {

    Optional<SideDish> findById(long id);
}
