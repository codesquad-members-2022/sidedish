package kr.codesquad.sidedish.repository;

import java.util.List;
import java.util.Optional;
import kr.codesquad.sidedish.domain.Product;

public abstract class ProvisionProductRepository implements ProductRepository {

	public abstract List<Product> loadListByType(String dishType, String sideDishType);

	public abstract Product updateQuantity(Integer id, Product product);

	@Override
	public Optional<Product> findById(Integer id) {
		return Optional.empty();
	}

	@Override
	public <S extends Product> S save(S entity) {
		return null;
	}

	@Override
	public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
		return null;
	}

	@Override
	public boolean existsById(Integer integer) {
		return false;
	}

	@Override
	public List<Product> loadDishListByType(String dishType) {
		return null;
	}

	@Override
	public List<Product> loadSideDishListByType(String dishType, String sideDishType) {
		return null;
	}

	@Override
	public void updateQuantity(Integer id, Integer quantity) {

	}

	@Override
	public List<Product> findAll() {
		return null;
	}

	@Override
	public Iterable<Product> findAllById(Iterable<Integer> integers) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Integer integer) {

	}

	@Override
	public void delete(Product entity) {

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> integers) {

	}

	@Override
	public void deleteAll(Iterable<? extends Product> entities) {

	}

	@Override
	public void deleteAll() {

	}
}
