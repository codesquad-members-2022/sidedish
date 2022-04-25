package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.reference.SideDish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SideDishRepository extends CrudRepository<SideDish, Long> {

    Optional<SideDish> findById(long id);
}
