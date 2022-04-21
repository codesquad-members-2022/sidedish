package com.terria.sidedish.repository;

import com.terria.sidedish.domain.Category;
import com.terria.sidedish.domain.DiscountEvent;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountEventRepository extends CrudRepository<DiscountEvent, Long>  {

    @Query("select id, title, discount_rate " +
            "from side_dish_to_discount_event  sd " +
            "join discount_event d " +
            "on sd.discount_event_id = d.id " +
            "where sd.side_dish_id = :sideDishId")
    List<DiscountEvent> findAllBySideDishId(Long sideDishId);
}
