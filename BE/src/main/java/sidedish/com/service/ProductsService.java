package sidedish.com.service;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import sidedish.com.controller.DomainDtoMapper;
import sidedish.com.controller.model.ProductDetailTypeResponse;
import sidedish.com.controller.model.ProductBasicTypeResponse;
import sidedish.com.domain.Product;
import sidedish.com.exception.NoSuchProductsException;
import sidedish.com.repository.DeliveryPolicyRepository;
import sidedish.com.repository.DiscountPolicyRepository;
import sidedish.com.repository.DomainEntityMapper;
import sidedish.com.repository.ProductsRepository;
import sidedish.com.repository.entity.DeliveryPolicyEntity;
import sidedish.com.repository.entity.DiscountPolicyEntity;
import sidedish.com.repository.entity.ProductEntity;

@Service
public class ProductsService {

	private final ProductsRepository productsRepository;
	private final DiscountPolicyRepository discountPolicyRepository;
	private final DeliveryPolicyRepository deliveryPolicyRepository;
	private final DomainDtoMapper domainDtoMapper;
	private final DomainEntityMapper domainEntityMapper;

	public ProductsService(ProductsRepository productsRepository,
		DiscountPolicyRepository discountPolicyRepository,
		DeliveryPolicyRepository deliveryPolicyRepository,
		DomainDtoMapper domainDtoMapper,
		DomainEntityMapper domainEntityMapper) {
		this.productsRepository = productsRepository;
		this.discountPolicyRepository = discountPolicyRepository;
		this.deliveryPolicyRepository = deliveryPolicyRepository;
		this.domainDtoMapper = domainDtoMapper;
		this.domainEntityMapper = domainEntityMapper;
	}

	public List<ProductBasicTypeResponse> findByMealType(String meal) {
		List<Product> products = domainEntityMapper.toDomainFromProductsEntity(
			productsRepository.findByMealType(meal),
			discountPolicyRepository.findAll(),
			deliveryPolicyRepository.findAll());

		validateProducts(products);

		return domainDtoMapper.toProductsBasicTypeResponseFromProducts(products);
	}

	public ProductDetailTypeResponse findById(Long id) {

		ProductEntity productEntity = productsRepository.findById(id).orElseThrow(() ->
			new NoSuchProductsException());
		List<DiscountPolicyEntity> discountPolicyEntities = discountPolicyRepository.findAll();
		List<DeliveryPolicyEntity> deliveryPolicyEntities = deliveryPolicyRepository.findAll();

		Product products = domainEntityMapper.toDomainFromProductEntity(productEntity,
			discountPolicyEntities, deliveryPolicyEntities);

		return domainDtoMapper.toProductDetailTypeFromProduct(products);
	}

	public List<ProductBasicTypeResponse> recommend() {
		List<ProductEntity> productEntities = productsRepository.findAll();
		List<DiscountPolicyEntity> discountPolicyEntities = discountPolicyRepository.findAll();
		List<DeliveryPolicyEntity> deliveryPolicyEntities = deliveryPolicyRepository.findAll();

		List<ProductEntity> recommendationProductEntity = recommendProducts(productEntities);

		List<Product> recommendationProducts = domainEntityMapper.toDomainFromProductsEntity(
			recommendationProductEntity,
			discountPolicyEntities, deliveryPolicyEntities);

		return domainDtoMapper.toProductsBasicTypeResponseFromProducts(recommendationProducts);
	}

	public List<ProductBasicTypeResponse> findAllByBestCategory(String category) {
		List<ProductEntity> productEntities =productsRepository.findAllByBestCategory(category);
		List<DiscountPolicyEntity> discountPolicyEntities = discountPolicyRepository.findAll();
		List<DeliveryPolicyEntity> deliveryPolicyEntities = deliveryPolicyRepository.findAll();

		List<Product> products = domainEntityMapper.toDomainFromProductsEntity(productEntities,
			discountPolicyEntities,
			deliveryPolicyEntities);

		validateProducts(products);

		return domainDtoMapper.toProductsBasicTypeResponseFromProducts(products);
	}

	private void validateProducts(List<Product> products) {
		if (products.isEmpty()) {
			throw new NoSuchProductsException();
		}
	}

	private List<ProductEntity> recommendProducts(List<ProductEntity> productEntities) {
		Collections.shuffle(productEntities);

		return productEntities.subList(0, 11);
	}
}
