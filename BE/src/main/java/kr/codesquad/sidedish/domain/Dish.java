package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

public class Dish {

    @Id
    private final Long id;
    private final Long categoryId;
    private final Long eventId;
    private final String name;
    private final String description;
    private final int stock;
    private final int price;
    private final DeliveryType deliveryType;
    private final DiscountPolicy discountPolicy;
    @MappedCollection(idColumn = "DISH_ID", keyColumn = "ID")
    private final List<Image> images;
    private final double pointPercent;

    public Dish(Long id, Long categoryId, Long eventId, String name, String description, int stock,
        int price, DeliveryType deliveryType,
        DiscountPolicy discountPolicy, List<Image> images, double pointPercent) {
        this.id = id;
        this.categoryId = categoryId;
        this.eventId = eventId;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.deliveryType = deliveryType;
        this.discountPolicy = discountPolicy;
        this.images = images;
        this.pointPercent = pointPercent;
    }

    public Long getId() {
        return id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    public List<Image> getImages() {
        return images;
    }

    public int getDiscountPrice() {
        return this.discountPolicy.calculate(this.price);
    }

    public String getImagePath(int imageIndex) {
        return this.images.get(imageIndex).getPath();
    }

    public double getPointPercent() {
        return pointPercent;
    }

    public int getPoint() {
        return (int) (getDiscountPrice() * this.pointPercent);
    }

    public boolean isOrderable(int quantity) {
        return this.stock >= quantity;
    }

    @Override
    public String toString() {
        return "Dish{" +
            "id=" + id +
            ", categoryId=" + categoryId +
            ", eventId=" + eventId +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", stock=" + stock +
            ", price=" + price +
            ", deliveryType=" + deliveryType +
            ", discountPolicy=" + discountPolicy +
            ", images=" + images +
            ", pointPercent=" + pointPercent +
            '}';
    }
}
