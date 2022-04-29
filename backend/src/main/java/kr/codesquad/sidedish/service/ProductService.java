package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.controller.dto.ProductResponse;
import kr.codesquad.sidedish.domain.DeliveryPolicy;
import kr.codesquad.sidedish.domain.Discount;
import kr.codesquad.sidedish.domain.Product;
import kr.codesquad.sidedish.repository.DeliveryPolicyRepository;
import kr.codesquad.sidedish.repository.DiscountRepository;
import kr.codesquad.sidedish.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final DiscountRepository discountRepository;
    private final DeliveryPolicyRepository deliveryPolicyRepository;

    public List<ProductResponse> readAllBy(Long categoryId, Long themeId, String sort, Long offset, Integer pageSize) {
        return productRepository
                .findAllByCategoryIdAndThemeId(categoryId, themeId, sort, offset, pageSize)
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());

    }

    public ProductResponse readFrom(Long productId) {
        return productRepository.findById(productId)
                .map(this::entityToDTO)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
    }

    private ProductResponse entityToDTO(Product product) {
        List<Discount> discounts = discountRepository.findAllById(product.getDiscountIds());

        Integer basePrice = product.getPrice();

        Integer finalPrice = applyHighestDiscount(basePrice, discounts);

        DeliveryPolicy deliveryPolicy = deliveryPolicyRepository
                .findById(product.getDeliveryPolicyId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 배달정책입니다."));

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .basePrice(basePrice)
                .finalPrice(finalPrice)
                .discounts(discounts)
                .mileage(Math.round(basePrice * product.getMileageRate()))
                .stock(product.getStock())
                .earlyMorningDelivery(deliveryPolicy.getEarlyMorningDelivery())
                .nationwideDelivery(deliveryPolicy.getNationwideDelivery())
                .deliveryRate(deliveryPolicy.getDeliveryRate())
                .freeDeliveryThreshold(deliveryPolicy.getFreeDeliveryThreshold())
                .primaryImage(product.getPrimaryImage())
                .variantImages(product.getVariantImageUrls())
                .build();
    }

    private Integer applyHighestDiscount(Integer basePrice, List<Discount> discounts) {
        return discounts.stream()
                .map(Discount::getDiscountRate)
                .max(Float::compareTo)
                .map(rate -> Math.round((1 - rate) * basePrice))
                .orElse(basePrice);
    }
}
