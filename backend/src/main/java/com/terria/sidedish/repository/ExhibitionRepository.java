package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.aggregate.Exhibition;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExhibitionRepository extends CrudRepository<Exhibition, Long> {

    Optional<Exhibition> findById(long id);
}
