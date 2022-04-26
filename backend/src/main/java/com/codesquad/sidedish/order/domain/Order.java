package com.codesquad.sidedish.order.domain;

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
public class Order {

    private static final int DELIVERY_LIMIT = 20_000;
    private static final double REWARD_RATE = 0.1;

    @Id
    @Column("order_id")
    private Integer id;
    private Integer dishId;
    private Integer price;
    private Integer quantity;
    private Integer rewardPoint;
    private Integer deliveryFee;

    @MappedCollection(idColumn = "order_id")
    private Set<OrderDelivery> deliveries = new HashSet<>();

    public Order(Integer dishId, Integer price, Integer quantity) {
        int totalPrice = price * quantity;

        this.dishId = dishId;
        this.price = price;
        this.quantity = quantity;
        this.rewardPoint = (int) (totalPrice * REWARD_RATE);
        this.deliveryFee = totalPrice > DELIVERY_LIMIT ? 0 : totalPrice;
    }

    public void setDeliveries(Set<OrderDelivery> deliveries) {
        this.deliveries = deliveries;
    }
}
