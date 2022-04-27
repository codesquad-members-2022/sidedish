package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Dish;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JdbcDishRepository extends CrudRepository<Dish, Long> {

    @Modifying
    @Query("update dish set is_deleted = true where id = :id")
    boolean delete(@Param("id") Long id);

    List<Dish> findDishesByCategoryId(Long categoryId);

    List<Dish> findDishesByCategoryId(Long categoryId, PageRequest pageRequest);

    @Modifying
    @Query("update dish set stock = stock - :quantity where id = :id")
    boolean updateStock(@Param("id") Long id, @Param("quantity") int quantity);

    @Query("select * from dish where category_id != :categoryId order by rand() limit 3")
    List<Dish> findDishesByOtherCategoryId(@Param("categoryId") Long categoryId);
}
