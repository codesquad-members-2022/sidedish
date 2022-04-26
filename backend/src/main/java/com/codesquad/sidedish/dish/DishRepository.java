package com.codesquad.sidedish.dish;

import com.codesquad.sidedish.dish.domain.Dish;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    @Query(value = "select d.* from dish d"
        + " join dish_category dc on d.dish_id = dc.dish_id"
        + " join category sub on dc.category_id = sub.category_id"
        + " join category sec on sub.section_id = sec.category_id and sec.category_name = :section_name"
        + " order by d.dish_id"
        + " limit :limit offset :offset")
    List<Dish> findBySectionName(
        @Param("section_name") String sectionName,
        @Param("limit") Integer limit,
        @Param("offset") Integer offset
    );

    @Query(value = "select d.* from dish d"
        + " join dish_category dc on d.dish_id = dc.dish_id"
        + " join category sub on dc.category_id = sub.category_id and sub.category_name = :category_name"
        + " order by d.dish_id"
        + " limit :limit offset :offset")
    List<Dish> findByCategoryName(
        @Param("category_name") String categoryName,
        @Param("limit") Integer limit,
        @Param("offset") Integer offset
    );

    @Query(value = "select d.* from dish d"
        + " where dish_id in (:dish_ids)"
        + " limit :limit offset :offset")
    List<Dish> findByIdIn(
        @Param("dish_ids") List<Integer> dishIds,
        @Param("limit") Integer limit,
        @Param("offset") Integer offset
    );

    List<Dish> findByIdIn(List<Integer> dishIds);
}
