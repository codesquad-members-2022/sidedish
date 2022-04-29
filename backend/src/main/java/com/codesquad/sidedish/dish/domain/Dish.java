package com.codesquad.sidedish.dish.domain;

import com.codesquad.sidedish.exception.ErrorCode;
import com.codesquad.sidedish.exception.unchecked.OutOfStockException;
import com.codesquad.sidedish.other.DiscountPolicy;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dish {

    @Id
    @Column(value = "dish_id")
    private Integer id;

    private String title;
    private String description;
    private int price;
    private Integer stock;

    @MappedCollection(idColumn = "dish_id")
    private Set<DishDiscount> discounts = new HashSet<>();

    @MappedCollection(idColumn = "dish_id")
    private Set<DishImage> images = new HashSet<>();

    @MappedCollection(idColumn = "dish_id")
    private Set<DishDelivery> deliveries = new HashSet<>();

    @MappedCollection(idColumn = "recommender_id")
    private Set<RecommendRef> recommends = new HashSet<>();

    public Dish(Integer id, String title, String description, Integer price, Integer stock) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    private void setDiscounts(Set<DishDiscount> discounts) {
        this.discounts = discounts;
    }

    private void setDishImages(Set<DishImage> images) {
        this.images = images;
    }

    private void setDeliveries(Set<DishDelivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void setRecommends(Set<RecommendRef> recommends) {
        this.recommends = recommends;
    }

    public int getDiscountPrice() {
        BigDecimal totalRate = discounts.stream()
            .map(DishDiscount::getCode)
            .map(DiscountPolicy::from)
            .map(DiscountPolicy::getRate)
            .map(rate -> 1 - rate)
            .map(BigDecimal::new)
            .reduce(BigDecimal.ONE, BigDecimal::multiply);

        return (int) (price * totalRate.doubleValue());
    }

    public void sold(int quantity) {
        if (stock < quantity) {
            throw new OutOfStockException(ErrorCode.DISH_OUT_OF_STOCK);
        }
        stock -= quantity;
    }

}
