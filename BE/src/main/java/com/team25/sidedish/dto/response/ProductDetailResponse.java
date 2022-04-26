package com.team25.sidedish.dto.response;

import com.team25.sidedish.domain.Delivery;
import com.team25.sidedish.domain.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "상품 상세 정보")
@Getter
@NoArgsConstructor
public class ProductDetailResponse {

    @Schema(description = "상품 아이디")
    private Long id;
    @Schema(description = "상품 이름")
    private String name;
    @Schema(description = "상품 이미지 URL")
    private List<String> imageUrls;
    @Schema(description = "상품 설명")
    private String description;
    @Schema(description = "상품 가격")
    private int price;
    @Schema(description = "할인된 상품 가격")
    private int discountPrice;
    @Schema(description = "이벤트 이름")
    private List<String> events;
    @Schema(description = "적립 포인트")
    private int point;
    @Schema(description = "배송 정보")
    private List<String> deliveryInfo;
    @Schema(description = "배송비")
    private int deliveryCost;
    @Schema(description = "배송비 무료 최소 가격")
    private int deliveryFreeCost;

    public static ProductDetailResponse from(Product product, List<String> eventNameList,
        double discountRate, List<String> deliveryInfoList, List<String> imageUrlList) {
        ProductDetailResponse productDetailResponse = new ProductDetailResponse();
        productDetailResponse.id = product.getId();
        productDetailResponse.name = product.getName();
        productDetailResponse.imageUrls = List.copyOf(imageUrlList);
        productDetailResponse.description = product.getDescription();
        productDetailResponse.price = product.getPrice();
        productDetailResponse.discountPrice = product.getDiscountPrice(discountRate);
        productDetailResponse.events = List.copyOf(eventNameList);
        productDetailResponse.point = product.getPoint(productDetailResponse.discountPrice);
        productDetailResponse.deliveryInfo = List.copyOf(deliveryInfoList);
        productDetailResponse.deliveryCost = Delivery.FEE;
        productDetailResponse.deliveryFreeCost = Delivery.FREE_PRICE;
        return productDetailResponse;
    }
}
