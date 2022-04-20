package sidedish.com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sidedish.com.domain.Product;
import sidedish.com.repository.ProductsRepository;

@Service
public class ProductsService {

	ProductsRepository productsRepository;

	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	public List<Product> findByMealType(String meal) {
		return productsRepository.findByMealType(meal);
	}
}
