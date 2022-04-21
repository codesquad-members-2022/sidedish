package sidedish.com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sidedish.com.controller.ProductsDtoMapper;
import sidedish.com.controller.model.ProductMealTypeResponse;
import sidedish.com.domain.Product;
import sidedish.com.repository.ProductsRepository;

@Service
public class ProductsService {

	ProductsRepository productsRepository;

	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	public List<ProductMealTypeResponse> findByMealType(String meal) {
		List<Product> products = productsRepository.findByMealType(meal);

		return ProductsDtoMapper.toProductsMealTypeResponseFromDomain(products);
	}
}
