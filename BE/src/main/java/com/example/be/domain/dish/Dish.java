package com.example.be.domain.dish;

import com.example.be.domain.image.Image;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Table("dish")
public class Dish {
    @Id
    private Long dishId;
    private String name;
    private String description;
    private BigDecimal price;
    private Badge badge;
    private DeliveryPriceOption deliveryPriceOption;
    private String thumbnail;
    private int count;
    private DishStatus dishStatus;

    @JoinColumn(joinColumn = "categoryId")
    private Long categoryId;

    @MappedCollection(idColumn = "dishId", keyColumn = "")
    private List<Image> images = new ArrayList<>();

    public Dish(String name, String description, BigDecimal price, Badge badge, DeliveryPriceOption deliveryPriceOption, String thumbnail, DishStatus dishStatus, int count, List<Image> images) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.badge = badge;
        this.deliveryPriceOption = deliveryPriceOption;
        this.thumbnail = thumbnail;
        this.dishStatus = dishStatus;
        this.count = count;
        this.images = images;
    }

    public Long getDishId() {
        return dishId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Badge getBadge() {
        return badge;
    }

    public DeliveryPriceOption getDeliveryType() {
        return deliveryPriceOption;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public DishStatus getDishStatus() {
        return dishStatus;
    }

    public int getCount() {
        return count;
    }

    public void changeName(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(dishId, dish.dishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId);
    }

}
