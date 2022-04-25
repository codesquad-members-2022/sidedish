package com.team25.sidedish.dto.response;

import com.team25.sidedish.domain.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "상품 정보")
@Getter
@NoArgsConstructor
public class ProductResponse {

    @Schema(description = "상품 아이디")
    private Long id;
    @Schema(description = "상품 이름")
    private String name;
    @Schema(description = "상품 이미지 URL")
    private String imageUrl;
    @Schema(description = "상품 설명")
    private String description;
    @Schema(description = "상품 가격")
    private int price;
    @Schema(description = "할인된 상품 가격")
    private int discountPrice;
    @Schema(description = "이벤트 이름")
    private List<String> events;

    public static ProductResponse from(Product product, List<String> events, double discountRate) {
        ProductResponse productResponse =  new ProductResponse();
        productResponse.id = product.getId();
        productResponse.name = product.getName();
        productResponse.imageUrl = product.getThumbnailImageUrl();
        productResponse.description = product.getDescription();
        productResponse.price = product.getPrice();
        productResponse.discountPrice = product.getDiscountPrice(discountRate);
        productResponse.events = List.copyOf(events);
        return productResponse;
    }
}
