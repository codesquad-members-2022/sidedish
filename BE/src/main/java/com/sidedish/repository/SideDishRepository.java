package com.sidedish.repository;

import com.sidedish.domain.SideDish;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SideDishRepository extends CrudRepository<SideDish, Integer> {

    @Query("SELECT s.id, name, description, dawn_delivery_flag, whole_nation_delivery_flag, price, "
        + "discount_type, IFNULL(discount_rate, 0) as discount_rate, save_file_name "
        + "FROM sidedish s LEFT JOIN discount_policy d ON s.discount_policy_id = d.id, image_file i "
        + "WHERE s.id = i.sidedish_id AND event_category_id = :eventCategoryId")
    List<SideDish> findAllByEventCategoryId(@Param("eventCategoryId") Integer eventCategoryId);
}
