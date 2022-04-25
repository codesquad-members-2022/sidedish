package kr.codesquad.sidedish.repository;

import java.util.List;
import java.util.Optional;
import kr.codesquad.sidedish.domain.Product;

public interface ProductRepository {

	Optional<Product> findById(Integer id);

	List<Product> loadListByType(String dishType, String sideDishType);

	Product updateQuantity(Integer id, Product product);

	List<Product> findAll();
}
