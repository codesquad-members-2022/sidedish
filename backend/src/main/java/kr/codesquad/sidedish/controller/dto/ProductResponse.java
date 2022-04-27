package kr.codesquad.sidedish.controller.dto;

import kr.codesquad.sidedish.domain.Discount;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductResponse {

    private final Long id;
    private final String name;
    private final String description;
    private final Integer basePrice;
    private final Integer finalPrice;
    private final List<Discount> discounts;
    private final Integer mileage;
    private final Integer stock;
    private final Boolean earlyMorningDelivery;
    private final Boolean nationwideDelivery;
    private final Integer deliveryRate;
    private final Integer freeDeliveryThreshold;
    private final String primaryImage;
    private final List<String> variantImages;

}
