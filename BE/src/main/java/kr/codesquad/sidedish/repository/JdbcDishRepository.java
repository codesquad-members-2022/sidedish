package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Dish;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JdbcDishRepository extends CrudRepository<Dish, Long> {

    @Modifying
    @Query("update dish set is_deleted = true where id = :id")
    public boolean delete(Long id);

    public List<Dish> findDishesByCategoryId(Long categoryId);

    @Query("select * from dish where category_id = :categoryId and id > :lastDishId limit 4")
    public List<Dish> findDishesByCategoryId(Long lastDishId, Long categoryId);

    public List<Dish> findDishesByCategoryId(Long categoryId, PageRequest pageRequest);
}
