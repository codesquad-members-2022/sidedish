package com.terria.sidedish.repository;

import com.terria.sidedish.domain.SideDish;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SideDishRepository extends CrudRepository<SideDish, Long> {

    @Query("select sd.id, sd.name, sd.description, sd.price, sd.accrual_rate, sd.shipping_fee, sd.exemption_condition" +
            " from category c join category_to_side_dish ctsd on c.id = ctsd.category_id" +
            " join side_dish sd on ctsd.side_dish_id = sd.id" +
            " where c.id = :categoryId")
    List<SideDish> findByCategoryId(long categoryId);
}
