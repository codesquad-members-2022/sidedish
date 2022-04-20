package com.terria.sidedish.repository;

import com.terria.sidedish.domain.Exhibition;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExhibitionRepository extends CrudRepository<Exhibition, Long> {

    @Query("select id, title from exhibition where id = :exhibitionId")
    Optional<Exhibition> findByExhibitionId(@Param("exhibitionId") long exhibitionId);
}
