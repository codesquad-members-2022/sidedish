package com.codesquad.sidedish.item.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("ITEM")
public class Item {
    @Id
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer stock;

    @Column(value = "MAIN_IMAGE_LINK")
    private String mainImageLink;

    @Column(value = "CATEGORY_ID")
    private Integer categoryId;

    @Column(value = "DISCOUNT_POLICY_ID")
    private Integer discountPolicyId;

    public Item(Integer id, String name, String description, Integer price, Integer stock, String mainImageLink, Integer categoryId, Integer discountPolicyId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.mainImageLink = mainImageLink;
        this.categoryId = categoryId;
        this.discountPolicyId = discountPolicyId;
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

    public Integer getDiscountPolicyId() {
        return discountPolicyId;
    }

    public Integer getCategoryId() {
        return categoryId;
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
                ", categoryId=" + categoryId +
                ", discountPolicyId=" + discountPolicyId +
                '}';
    }
}
