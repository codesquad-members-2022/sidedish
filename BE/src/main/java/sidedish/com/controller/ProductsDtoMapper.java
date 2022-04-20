package sidedish.com.controller;

import sidedish.com.controller.model.ProductsMealTypeResponse;
import sidedish.com.domain.Product;

public class ProductsDtoMapper {

	private ProductsDtoMapper() {
	}

	public static ProductsMealTypeResponse toProductsMealTypeResponseFromDomain(Product product) {
		return new ProductsMealTypeResponse(product.getId()
			, product.getImage().get(0).getImage(),
			product.getProductName(),
			product.getDescription(),
			product.getFixedPrice(),
			product.getOriginalPrice(),
			product.getDisCountPolicy().getPolicyName());

	}
}
