package sidedish.com.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import sidedish.com.controller.model.OrderSaveResponse;
import sidedish.com.controller.model.ProductDetailTypeResponse;
import sidedish.com.controller.model.ProductBasicTypeResponse;
import sidedish.com.controller.model.UserResponse;
import sidedish.com.domain.Product;
import sidedish.com.domain.User;
import sidedish.com.repository.entity.OrderEntity;

@Component
public class DomainDtoMapper {

	public List<ProductBasicTypeResponse> toProductsBasicTypeResponseFromProducts(
		List<Product> products) {
		return products.stream()
			.map(this::toProductMealTypeResponseFromProduct)
			.collect(Collectors.toList());
	}

	private ProductBasicTypeResponse toProductMealTypeResponseFromProduct(
		Product product) {
		return new ProductBasicTypeResponse(
			product.getId(),
			product.getImages().get(0).getImageUrl(),
			product.getProductName(),
			product.getDescription(),
			product.getFixedPrice(),
			product.getOriginalPrice(),
			product.getDiscountPolicy().getPolicyName());
	}

	public ProductDetailTypeResponse toProductDetailTypeFromProduct(
		Product product) {
		return new ProductDetailTypeResponse(
			product.getId(),
			product.getImages(),
			product.getProductName(),
			product.getDescription(),
			product.getFixedPrice(),
			product.getOriginalPrice(),
			product.getDiscountPolicy().getPolicyName(),
			product.getMileage(),
			product.getDeliveryPolicy().getDeliveryInfo(),
			product.getDeliveryPolicy().getDeliveryCharge(),
			product.getDeliveryPolicy().getFreeDeliveryOverAmount()
			);
	}

	public OrderSaveResponse toOrderSaveResponseFromOrder(OrderEntity orderEntity) {
		return new OrderSaveResponse(orderEntity.getId());
	}

	public UserResponse toUserResponseFromUser(User user) {
		return new UserResponse(user.getId(), user.getUserName(), user.getAvatarImageURL());
	}
}
