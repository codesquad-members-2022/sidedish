package com.codesquad.sidedish.item.domain;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Override
    List<Category> findAll();

    @Query("SELECT I.* FROM category C JOIN item I ON C.ID = I.CATEGORY_ID WHERE I.ID = :id")
    Optional<Item> findByItemId(@Param("id") int id);
}
