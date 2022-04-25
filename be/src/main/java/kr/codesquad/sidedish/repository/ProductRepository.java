package kr.codesquad.sidedish.repository;

import java.util.List;
import java.util.Optional;
import kr.codesquad.sidedish.domain.Product;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("SELECT * FROM PRODUCT WHERE id = :id")
	Optional<Product> findById(@Param("id") Integer id);

	@Query("SELECT * FROM PRODUCT WHERE dish_type = :dishType AND side_dish_type = :sideDishType")
	List<Product> loadListByType(@Param("dishType") String dishType,
		@Param("sideDishType") String sideDishType);

	@Modifying
	@Query("UPDATE PRODUCT SET quantity = :quantity WHERE id = :id")
	Product updateQuantity(@Param("id") Integer id, @Param("quantity") Integer quantity);
	//Product updateQuantity(@Param("id") Integer id, Product product);

	@Query("SELECT * FROM PRODUCT")
	List<Product> findAll();
}
