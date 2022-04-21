package com.sidedish.repository;


import com.sidedish.domain.Item;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("SELECT i.* FROM items as i join item_order as io on i.id = io.item where io.orders = :id")
    Set<Item> findByOrderId(@Param("id") Long id);
}
