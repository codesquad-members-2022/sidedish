package com.sidedish.repository;

import com.sidedish.domain.Category;
import com.sidedish.domain.CategoryType;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("SELECT id FROM category WHERE type=:type")
    Long findCategoeyId(@Param("type") CategoryType type);
}
