package com.team25.sidedish.dto.response;

import com.team25.sidedish.domain.Delivery;
import com.team25.sidedish.domain.Product;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDetailResponse {

    private Long id;
    private String name;
    private List<String> imageUrls;
    private String description;
    private int price;
    private int discountPrice;
    private List<String> events;
    private int point;
    private List<String> deliveryInfo;
    private int deliveryCost;
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
