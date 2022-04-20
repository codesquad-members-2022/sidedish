package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.dto.DishSimpleResponse;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JdbcDishRepository extends CrudRepository<Dish, Long> {

    @Modifying
    @Query("update dish set is_deleted = true where id = :id")
    public boolean softDelete(Long id);

    @Query("select d.id, d.name, d.description, d.stock, d.price, d.discount_policy, i.name " +
            "from DISH d " +
            "left outer join IMAGE i" +
            "ON d.id = i.dish_id" +
            "where d.category_id = :categoryId")
    public List<DishSimpleResponse> findAllByCategoryId(Long categoryId);

    public List<Dish> findDishesByMainCategoryId(Long categoryId);
}
