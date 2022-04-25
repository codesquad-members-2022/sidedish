package kr.codesquad.sidedish.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import kr.codesquad.sidedish.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryProductRepository implements ProductRepository {

	private static final Map<Integer, Product> store = new HashMap<>();

	private static final AtomicInteger sequence = new AtomicInteger();

	@Override
	public Optional<Product> findById(Integer id) {

		Optional<Product> optional = Optional.ofNullable(store.get(id));

		return optional;
	}

	@Override
	public List<Product> loadListByType(String dishType, String sideDishType) {
		return store.values().stream()
			.filter(p -> p.isSameDishType(dishType))
			.filter(p -> p.isSameSideDishType(sideDishType))
			.collect(Collectors.toList());
	}

	@Override
	public Product updateQuantity(Integer id, Product product) {
		store.put(id, product);
		return product;
	}

	@Override
	public List<Product> findAll() {
		return null;
	}
}
