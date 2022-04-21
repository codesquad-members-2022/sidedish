package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    @Query(value = "select d.dish_id, d.title, d.description, d.price, d.stock,"
        + " eb.event_badge_id, eb.event_badge_name, eb.discount,"
        + " di.dish_image_id, di.image_path, dc.category_id"
        + " from dish d"
        + " left outer join event_badge eb on d.event_badge_id = eb.event_badge_id"
        + " left outer join dish_image di on d.dish_id = di.dish_id and di.sequence = 1"
        + " join dish_category dc on d.dish_id = dc.dish_id"
        + " join category sub on dc.category_id = sub.category_id"
        + " join category sec on sub.section_id = sec.category_id and sec.category_name = :section_name"
        + " order by d.dish_id",
        rowMapperClass = DishRowMapper.class)
    List<Dish> findBySectionName(@Param("section_name") String sectionName);

    @Query(value = "select d.dish_id, d.title, d.description, d.price, d.stock,"
        + " eb.event_badge_id, eb.event_badge_name, eb.discount,"
        + " di.dish_image_id, di.image_path, dc.category_id"
        + " from dish d"
        + " left outer join event_badge eb on d.event_badge_id = eb.event_badge_id"
        + " left outer join dish_image di on d.dish_id = di.dish_id and di.sequence = 1"
        + " join dish_category dc on d.dish_id = dc.dish_id"
        + " join category sub on dc.category_id = sub.category_id and sub.category_name = :category_name"
        + " order by d.dish_id",
        rowMapperClass = DishRowMapper.class)
    List<Dish> findByCategoryName(@Param("category_name") String categoryName);
}
