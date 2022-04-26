package com.codesquad.sidedish.item.domain;

import java.util.HashSet;
import java.util.Set;

import com.codesquad.sidedish.item.exception.OutOfStockException;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class Item {
    @Id
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer stock;
    @Column(value = "MAIN_IMAGE_LINK")
    private String mainImageLink;
    private String discountPolicy;
    private Integer discountRate;
    @MappedCollection(idColumn = "ITEM_ID")
    private Set<ItemImage> itemImages = new HashSet<>();

    public Item(Integer id, String name, String description, Integer price, Integer stock, String mainImageLink, String discountPolicy, Integer discountRate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.mainImageLink = mainImageLink;
        this.discountPolicy = discountPolicy;
        this.discountRate = discountRate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getMainImageLink() {
        return mainImageLink;
    }

    public String getDiscountPolicy() {
        return discountPolicy;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public Set<ItemImage> getItemImages() {
        return itemImages;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", mainImageLink='" + mainImageLink + '\'' +
                ", discountPolicy='" + discountPolicy + '\'' +
                ", discountRate=" + discountRate +
                ", itemImages=" + itemImages +
                '}';
    }

    public void removeStock(Integer amount) {
        if (stock < amount) {
            throw new OutOfStockException("재고가 부족합니다.");
        }
        stock -= amount;
    }
}
