package sidedish.com.controller;

import java.util.List;
import java.util.stream.Collectors;
import sidedish.com.controller.model.ProductMealTypeResponse;
import sidedish.com.domain.Product;

public class ProductsDtoMapper {

	private ProductsDtoMapper() {
	}

	public static List<ProductMealTypeResponse> toProductsMealTypeResponseFromDomain(
		List<Product> products) {
		return products.stream()
			.map(ProductsDtoMapper::toProductMealTypeResponseFromDomain)
			.collect(Collectors.toList());
	}


	private static ProductMealTypeResponse toProductMealTypeResponseFromDomain(Product product) {
		return new ProductMealTypeResponse(
			product.getId(),
			product.getImage().get(0).getImage(),
			product.getProductName(),
			product.getDescription(),
			product.getFixedPrice(),
			product.getOriginalPrice(),
			product.getDisCountPolicy().getPolicyName());
	}

}
