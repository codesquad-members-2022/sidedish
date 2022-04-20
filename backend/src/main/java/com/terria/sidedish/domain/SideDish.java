package com.terria.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class SideDish {

    @Id
    private long id;
    private String name;
    private String description;
    private int price;
    private double accrualRate;

    // FK
    private long categoryId;
}
