package sidedish.com.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sidedish.com.repository.entity.ProductEntity;

@Repository
public interface ProductsRepository extends CrudRepository<ProductEntity, Long> {

	@Query("select id, discount_policy_id, product_name, description, original_price, meal_category "
		+ "from PRODUCT where meal_category = :mealType")
	List<ProductEntity> findByMealType(@Param("mealType") String mealType);
}
