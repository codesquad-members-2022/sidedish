package kr.codesquad.sidedish.repository;

import java.util.List;
import kr.codesquad.sidedish.domain.Product;

public interface ProductRepository {

	Product findById(int id);

	List<Product> loadListByType(String dishType, String sideDishType);

	Product save(Product product);

	Product updateQuantity(int id, Product product);

	List<Product> findAll();
}
