package sidedish.com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sidedish.com.controller.ProductsDtoMapper;
import sidedish.com.controller.model.ProductMealTypeResponse;
import sidedish.com.domain.Product;
import sidedish.com.exception.NoSuchProductsException;
import sidedish.com.repository.DiscountPolicyRepository;
import sidedish.com.repository.DomainEntityMapper;
import sidedish.com.repository.ProductsRepository;

@Service
public class ProductsService {

	private final ProductsRepository productsRepository;
	private final DiscountPolicyRepository discountPolicyRepository;
	private final ProductsDtoMapper productsDtoMapper;
	private final DomainEntityMapper domainEntityMapper;

	public ProductsService(ProductsRepository productsRepository,
		DiscountPolicyRepository discountPolicyRepository,
		ProductsDtoMapper productsDtoMapper,
		DomainEntityMapper domainEntityMapper) {
		this.productsRepository = productsRepository;
		this.discountPolicyRepository = discountPolicyRepository;
		this.productsDtoMapper = productsDtoMapper;
		this.domainEntityMapper = domainEntityMapper;
	}

	public List<ProductMealTypeResponse> findByMealType(String meal) {
		List<Product> products = domainEntityMapper.toDomainFromProductsEntity(
			productsRepository.findByMealType(meal),
			discountPolicyRepository.findAll());

		validProducts(products);

		return productsDtoMapper.toProductsMealTypeResponseFromDomain(products);
	}

	private void validProducts(List<Product> products) {
		if (products.isEmpty()) {
			throw new NoSuchProductsException();
		}
	}
}
