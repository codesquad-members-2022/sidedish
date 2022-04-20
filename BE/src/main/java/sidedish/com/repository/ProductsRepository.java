package sidedish.com.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import sidedish.com.domain.Product;

@Repository
public interface ProductsRepository {

	List<Product> findByMealType(String meal);
}
