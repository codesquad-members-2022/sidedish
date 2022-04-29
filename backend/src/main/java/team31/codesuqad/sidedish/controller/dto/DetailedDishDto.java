package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class DetailedDishDto {

    private final Long dishId;
    private final String title;
    private final Integer price;
    private final Integer point;
    private final String deliveryArea;
    private final Boolean deliveryMorning;
    private final Integer deliveryPrice;
    private final Integer stockQuantity;
    private List<ImageDto> images;
    private List<DiscountDto> eventBadge;

    public DetailedDishDto(Dish dish, Delivery delivery) {
        this.dishId = dish.getId();
        this.title = dish.getTitle();
        this.price = dish.getPrice();
        this.point = dish.getPoint();
        this.deliveryArea = delivery.getDeliveryArea();
        this.deliveryMorning = delivery.getDeliveryMorning();
        this.deliveryPrice = delivery.getDeliveryPay();
        this.stockQuantity = dish.getStockQuantity();
        this.images = makeImages(dish.getImages());
        this.eventBadge = makeEventBadge(dish.getDiscountPolicies());
    }

    private List<ImageDto> makeImages(List<Image> images) {
        return images.stream()
                .map(ImageDto::new)
                .collect(Collectors.toList());
    }

    private List<DiscountDto> makeEventBadge(List<DiscountPolicy> discounts) {
        return discounts.stream()
                .map(DiscountDto::new)
                .collect(Collectors.toList());
    }

    public Long getDishId() {
        return dishId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPoint() {
        return point;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    public Boolean getDeliveryMorning() {
        return deliveryMorning;
    }

    public Integer getDeliveryPrice() {
        return deliveryPrice;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public List<DiscountDto> getEventBadge() {
        return eventBadge;
    }
}
