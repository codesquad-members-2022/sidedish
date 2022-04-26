package sidedish.com.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sidedish.com.repository.entity.ProductEntity;

public interface ProductsRepository extends CrudRepository<ProductEntity, Long> {

	@Override
	List<ProductEntity> findAll();

	@Query("select id, discount_policy_id, delivery_policy_id, product_name, description, original_price, stock_quantity, meal_category "
		+ "from PRODUCT where meal_category = :mealType")
	List<ProductEntity> findByMealType(@Param("mealType") String mealType);

	List<ProductEntity> findAllByBestCategory(String category);

	@Modifying
	@Query("update PRODUCT set stock_quantity = :stockQuantity where id = :id")
	void update(@Param("stockQuantity") long stockQuantity, @Param("id") Long id);
}
