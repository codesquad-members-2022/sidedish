package sidedish.com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import sidedish.com.domain.DeliveryPolicy;
import sidedish.com.domain.DiscountPolicy;
import sidedish.com.domain.Image;
import sidedish.com.domain.Order;
import sidedish.com.domain.Product;
import sidedish.com.repository.entity.DeliveryPolicyEntity;
import sidedish.com.repository.entity.DiscountPolicyEntity;
import sidedish.com.repository.entity.ImageEntity;
import sidedish.com.repository.entity.OrderEntity;
import sidedish.com.repository.entity.ProductEntity;

@Component
public class DomainEntityMapper {

    public List<Product> toDomainFromProductsEntity(List<ProductEntity> productEntities,
        List<DiscountPolicyEntity> discountPolicyEntities,
        List<DeliveryPolicyEntity> deliveryPolicyEntities) {
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            products.add(toDomainFromProductEntity(productEntity, discountPolicyEntities,
                deliveryPolicyEntities));
        }
        return products;
    }

    public Product toDomainFromProductEntity(ProductEntity productEntity,
        List<DiscountPolicyEntity> discountPolicyEntities,
        List<DeliveryPolicyEntity> deliveryPolicyEntities) {

        DiscountPolicyEntity discountPolicyEntity = searchDiscountPolicyEntity(
            discountPolicyEntities, productEntity);
        DeliveryPolicyEntity deliveryPolicyEntity = searchDeliveryPolicyEntity(
            deliveryPolicyEntities, productEntity);

        return createProduct(productEntity, discountPolicyEntity, deliveryPolicyEntity);
    }

    public OrderEntity toOrderEntityFromDomain(Order order) {
        return new OrderEntity(order.getProduct().getId(), order.getTotalPrice(),
            order.getCount(), order.getDeliveryPrice());
    }

    public Product createProduct(ProductEntity productEntity,
        DiscountPolicyEntity discountPolicyEntity,
        DeliveryPolicyEntity deliveryPolicyEntity) {

        DiscountPolicy discountPolicy = toDomainFromDiscountPolicyEntity(discountPolicyEntity);
        DeliveryPolicy deliveryPolicy = toDomainFromDeliveryPolicyEntity(
            deliveryPolicyEntity);
        List<Image> images = toDomainFromImageEntity(productEntity);

        return new Product(
            productEntity.getId(),
            discountPolicy,
            deliveryPolicy,
            images,
            productEntity.getProductName(),
            productEntity.getDescription(),
            productEntity.getOriginalPrice(),
            productEntity.getStockQuantity(),
            productEntity.getMealCategory(),
            productEntity.getBestCategory());
    }

    private DiscountPolicyEntity searchDiscountPolicyEntity(
        List<DiscountPolicyEntity> discountPolicies, ProductEntity productEntity) {
        for (DiscountPolicyEntity discountPolicyEntity : discountPolicies) {
            if (discountPolicyEntity.isEqualsId(productEntity.getDiscountPolicyId())) {
                return discountPolicyEntity;
            }
        }
        return new DiscountPolicyEntity(null, null, 0);
    }

    private DeliveryPolicyEntity searchDeliveryPolicyEntity(
        List<DeliveryPolicyEntity> deliveryPolicyEntities, ProductEntity productEntity) {

        for (DeliveryPolicyEntity deliveryPolicyEntity : deliveryPolicyEntities) {
            if (deliveryPolicyEntity.isEqualsId(productEntity.getDeliveryPolicyId())) {
                return deliveryPolicyEntity;
            }
        }
        return null;
    }

    private DiscountPolicy toDomainFromDiscountPolicyEntity(
        DiscountPolicyEntity discountPolicyEntity) {
        return new DiscountPolicy(
            discountPolicyEntity.getPolicyName(),
            discountPolicyEntity.getDiscountRate());
    }

    private DeliveryPolicy toDomainFromDeliveryPolicyEntity(
        DeliveryPolicyEntity deliveryPolicyEntity) {

        return new DeliveryPolicy(
            deliveryPolicyEntity.getDeliveryInfo(),
            deliveryPolicyEntity.getDeliveryCharge(),
            deliveryPolicyEntity.getFreeDeliveryOverAmount());
    }

    private List<Image> toDomainFromImageEntity(ProductEntity productEntity) {
        return productEntity.getImageEntities().stream()
            .map(imageEntity -> new Image(imageEntity.getImageUrl()))
            .collect(Collectors.toList());
    }
}
