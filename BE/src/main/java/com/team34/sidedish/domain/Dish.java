package com.team34.sidedish.domain;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Dish {

    @Id
    private Long id;
    private String title;
    private String content;
    private String tag;
    private int price;
    private int stock;
    private int deliveryFee;
    private Integer freeShippingAmount;
    private double mileageRate;
    private boolean earlyDeliverable;

    @MappedCollection(idColumn = "dish_id", keyColumn = "id")
    private List<CategoryDish> categories;

    @MappedCollection(idColumn = "dish_id", keyColumn = "id")
    private List<DishImage> images;

    @Override
    public String toString() {
        return "Dish{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", price=" + price +
            ", stock=" + stock +
            ", deliveryFee=" + deliveryFee +
            ", freeShippingAmount=" + freeShippingAmount +
            ", mileageRate=" + mileageRate +
            ", earlyDeliverable=" + earlyDeliverable +
            ", categories=" + categories +
            ", images=" + images +
            '}';
    }
}
