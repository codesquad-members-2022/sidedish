package com.sidedish.repository;


import com.sidedish.domain.CategoryType;
import com.sidedish.domain.Item;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.Set;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

    @Query("SELECT i.* FROM items as i join item_order as io on i.id = io.item where io.orders = :id")
    Set<Item> findByOrderId(@Param("id") Long id);

    List<Item> findByCategoryType(CategoryType type, PageRequest pageable);

    @Query("SELECT * FROM items WHERE detail_type = :detailType ORDER BY RAND() LIMIT 3")
    List<Item> findByDetailType(@Param("detailType") String detailType);

}
