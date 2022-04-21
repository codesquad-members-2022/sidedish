package com.team25.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Product {
    @Id
    private Long id;
    private String name;
    private int price;
    private String discription;
    private int stock;

    public Product(String name, int price, String discription, int stock) {
        this.name = name;
        this.price = price;
        this.discription = discription;
        this.stock = stock;
    }
}
