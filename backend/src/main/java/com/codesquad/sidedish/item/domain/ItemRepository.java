package com.codesquad.sidedish.item.domain;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    @Query("SELECT i.*, c.NAME FROM ITEM i JOIN CATEGORY c ON i.CATEGORY_ID = c.id;")
    List<Item> findAll();

    @Query("SELECT * FROM ITEM WHERE CATEGORY_ID = :categoryId")
    List<Item> findByCategoryId(@Param("categoryId") Integer categoryId);
}
