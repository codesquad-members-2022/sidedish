package com.terria.sidedish.repository;

import com.terria.sidedish.domain.Category;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("select id, title, parent, exhibition_id" +
            " from category" +
            " where exhibition_id = :exhibitionId")

    List<Category> findByExhibitionId(@Param("exhibitionId") long exhibitionId);
}
