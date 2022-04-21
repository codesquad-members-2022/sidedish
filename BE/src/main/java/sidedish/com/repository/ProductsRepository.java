package sidedish.com.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sidedish.com.domain.Product;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {

	@Query("select id, discount_policy_id, product_name, description, original_price, meal_category "
		+ "from product where meal_category = :mealType")
	List<Product> findByMealType(@Param("mealType") String mealType);
}
