package com.codesquad.sidedish.item.domain;

import org.springframework.data.annotation.Id;

public class Item {
    @Id
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private Integer stock;
    private String imageLink;

    public Item(Integer id, String name, String description, Integer price, Integer stock, String imageLink) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imageLink = imageLink;
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

    public String getImageLink() {
        return imageLink;
    }
}
