package com.team25.sidedish.dto.response;

import com.team25.sidedish.domain.Product;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private String imageUrl;
    private String description;
    private int price;
    private int discountPrice;
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
