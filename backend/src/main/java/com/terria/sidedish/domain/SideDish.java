package com.terria.sidedish.domain;

import lombok.Getter;

@Getter
public class SideDish {

    private long id;
    private String name;
    private String description;
    private int price;
    private double accrualRate;

    // FK
    private long categoryId;
}
