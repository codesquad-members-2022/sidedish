package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.aggregate.Exhibition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExhibitionRepository extends CrudRepository<Exhibition, Long> {

    Optional<Exhibition> findById(long id);
}
