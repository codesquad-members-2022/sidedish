package team31.codesuqad.sidedish.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import team31.codesuqad.sidedish.domain.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    @Override
    List<Dish> findAll();

    Optional<Dish> findById(long dishId);

    @Query(value = "select id, price, title, description, stock_quantity," +
            " point, category_id, delivery_id, event_tabs_id" +
            " from dishes where event_tabs_id = :id " +
            "order by rand() limit 3;")
    List<Dish> findThreeByEventTabId(@Param("id") Integer eventId);

    @Query(value = "select id, price, title, description, stock_quantity," +
            " point, category_id, delivery_id, event_tabs_id" +
            " from dishes where category_id = :id")
    List<Dish> findAllByCategoryId(@Param("id") Integer eventId);

    @Query(value = "select id, price, title, description, stock_quantity," +
            " point, category_id, delivery_id, event_tabs_id" +
            " from dishes where category_id = 1 limit 5 offset :offsetNumber")
    List<Dish> findRecommendedPage(@Param("offsetNumber") int offsetNumber);

    @Query(value = "select count(id) from dishes where category_id = 1")
    int findRecommendSize();

}
