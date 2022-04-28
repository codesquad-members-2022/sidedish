package com.team25.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Event {

    @Id
    private Long id;
    private String name;
    private double discountRate;

    public Event(String name, double discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }
}
