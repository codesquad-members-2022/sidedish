package com.team35.sidedish.repository;

import com.team35.sidedish.domain.entity.aggregate.SideDish;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface SideDishRepository extends CrudRepository<SideDish, Long> {

    @Query("select s.id, s.name, s.description, s.price, s.accrual_rate, s.stock, s.shipping_info, s.shipping_fee, s.exemption_condition"
            + " from side_dish s"
            + " join category_has_side_dish c"
            + " on s.id = c.side_dish_id"
            + " where c.category_id = :categoryId"
            + " limit :startIndex, :itemCount")
    List<SideDish> findByCategoryId(long categoryId, int startIndex, int itemCount);

    @Query("select count(id)"
            + " from side_dish s"
            + " join category_has_side_dish c"
            + " on s.id = c.side_dish_id"
            + " where c.category_id = :categoryId")
    int countByCategoryId(long categoryId);

    @Modifying
    @Query("update side_dish set stock = :stock  where id = :id")
    int updateStockById(long id, int stock);
}

