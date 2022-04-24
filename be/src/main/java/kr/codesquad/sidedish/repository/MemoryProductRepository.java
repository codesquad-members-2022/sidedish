package kr.codesquad.sidedish.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import kr.codesquad.sidedish.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryProductRepository implements ProductRepository {

	private static final Map<Integer, Product> store = new HashMap<>();

	private static final AtomicInteger sequence = new AtomicInteger();

	@Override
	public Product findById(Integer id) {
		return store.get(id);
	}

	@Override
	public List<Product> loadListByType(String dishType, String sideDishType) {
		return store.values().stream()
			.filter(p -> p.isSameDishType(dishType))
			.filter(p -> p.isSameSideDishType(sideDishType))
			.collect(Collectors.toList());
	}

	@Override
	public Product save(Product product) {
		Integer id = sequence.incrementAndGet();

		return null;
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
