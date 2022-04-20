package com.sidedish.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Table(value = "items")
public class Item {

    @Id
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private double discountRate;
    private Badge badge;
    private String detailType;
    private int quantity;
    private BigDecimal rewardPoint;
    private String image;

    private Set<OrderRef> orders = new HashSet<>();

    public Item(String title, String description, BigDecimal price, double discountRate, Badge badge, String detailType, int quantity, BigDecimal rewardPoint, String image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountRate = discountRate;
        this.badge = badge;
        this.detailType = detailType;
        this.quantity = quantity;
        this.rewardPoint = rewardPoint;
        this.image = image;
    }

    void addOrders(Order order) {
        this.orders.add(new OrderRef(order.getId()));
    }

    Set<Long> getOderIds() {
        return this.orders.stream()
                .map(OrderRef::getOrder)
                .collect(Collectors.toSet());
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountRate=" + discountRate +
                ", badge=" + badge +
                ", detailType='" + detailType + '\'' +
                ", quantity=" + quantity +
                ", rewardPoint=" + rewardPoint +
                ", image='" + image + '\'' +
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
