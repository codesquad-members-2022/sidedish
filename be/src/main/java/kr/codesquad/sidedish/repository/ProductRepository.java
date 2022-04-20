package kr.codesquad.sidedish.repository;

import java.util.List;
import kr.codesquad.sidedish.domain.Product;

public interface ProductRepository {

	Product findById(Integer id);

	List<Product> loadListByType(String dishType, String sideDishType);

	Product save(Product product);

	Product updateQuantity(Integer id, Product product);

	List<Product> findAll();
}
