package com.terria.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
@ToString
public class DiscountEvent {

    @Id
    private long id;
    private String title;
    private double discountRate;
}
