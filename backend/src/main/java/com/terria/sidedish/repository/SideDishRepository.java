package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.aggregate.SideDish;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SideDishRepository extends CrudRepository<SideDish, Long> {

    @Query("select s.id, s.name, s.description, s.price, s.accrual_rate, s.stock, s.shipping_info, s.shipping_fee, s.exemption_condition"
            + " from side_dish s"
            + " join category_has_side_dish c"
            + " on s.id = c.side_dish_id"
            + " where c.category_id = :categoryId")
    List<SideDish> findByCategoryId(long categoryId);
}
