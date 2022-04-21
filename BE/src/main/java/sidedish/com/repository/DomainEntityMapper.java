package sidedish.com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import sidedish.com.domain.DiscountPolicy;
import sidedish.com.domain.Image;
import sidedish.com.domain.Product;
import sidedish.com.repository.entity.DiscountPolicyEntity;
import sidedish.com.repository.entity.ProductEntity;

@Component
public class DomainEntityMapper {

	public List<Product> toDomainFromProductsEntity(List<ProductEntity> productEntities,
		List<DiscountPolicyEntity> discountPolicies) {
		List<Product> products = new ArrayList<>();
		for (ProductEntity productEntity : productEntities) {
			Long discountPolicyId = productEntity.getDiscountPolicyId();
			for (DiscountPolicyEntity discountPolicyEntity : discountPolicies) {
				if (discountPolicyEntity.isEqualsId(discountPolicyId)) {
					Product product = toDomainFromProductEntity(productEntity, discountPolicyEntity);
					products.add(product);
				}
			}
		}
		return products;
	}

	private Product toDomainFromProductEntity(ProductEntity productEntity,
		DiscountPolicyEntity discountPolicyEntity) {
		DiscountPolicy discountPolicy = toDomainFromDiscountPolicyEntity(discountPolicyEntity);

		List<Image> images = toDomainFromImageEntity(productEntity);

		return new Product(
			productEntity.getId(),
			discountPolicy,
			images,
			productEntity.getProductName(),
			productEntity.getDescription(),
			productEntity.getOriginalPrice(),
			productEntity.getMealCategory(),
			productEntity.getBestCategory());
	}

	private List<Image> toDomainFromImageEntity(ProductEntity productEntity) {
		return productEntity.getImageEntities().stream()
			.map(imageEntity -> new Image(imageEntity.getImageUrl()))
			.collect(Collectors.toList());
	}

	private DiscountPolicy toDomainFromDiscountPolicyEntity(DiscountPolicyEntity discountPolicyEntity) {
		return new DiscountPolicy(
			discountPolicyEntity.getPolicyName(),
			discountPolicyEntity.getDiscountRate());
	}
}
