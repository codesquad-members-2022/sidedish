package com.codesquad.sidedish.dish;

import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    @Query(value = "select d.dish_id, d.title, d.description, d.price, d.stock,"
        + " eb.event_badge_name, eb.discount from dish d"
        + " left outer join event_badge eb on d.event_badge_id = eb.event_badge_id", rowMapperClass = DishRowMapper.class)
    Optional<Dish> findByIdWithEventBadge(Integer dishId);
}
