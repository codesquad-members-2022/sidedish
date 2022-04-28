package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class DetailedDishDto {

    private Long dishId;
    private String title;
    private Integer price;
    private Integer point;
    private String deliveryArea;
    private Boolean deliveryMorning;
    private Integer deliveryPrice;
    private Integer stockQuantity;
    private List<ImageDto> images;
    private List<DiscountDto> eventBadge;

    public DetailedDishDto(Dishes dish, Deliveries delivery) {
        this.dishId = dish.getId();
        this.title = dish.getTitle();
        this.price = dish.getPrice();
        this.stockQuantity = dish.getStockQuantity();
        this.deliveryArea = delivery.getDeliveryArea();
        this.deliveryMorning = delivery.getDeliveryMorning();
        this.deliveryPrice = delivery.getDeliveryPay();
        makeImages(dish.getImages());
        makeEventBadge(dish.getEventBadge());
    }

    private void makeImages(List<Images> images) {
        this.images = images.stream()
                .map(ImageDto::new)
                .collect(Collectors.toList());
    }

    private void makeEventBadge(List<DiscountPolicies> discounts) {
        this.eventBadge = discounts.stream()
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
