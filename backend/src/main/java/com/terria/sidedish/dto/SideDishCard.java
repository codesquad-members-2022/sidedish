package com.terria.sidedish.dto;

import com.terria.sidedish.domain.DiscountEvent;
import com.terria.sidedish.domain.SideDish;
import com.terria.sidedish.domain.SideDishImage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class SideDishCard {

    private long sideDishId;
    private String imageUrl;
    private String name;
    private String description;
    private double disCountPrice;
    private int price;
    private List<String> discountEvents;

    public static SideDishCard of(SideDish sideDish, SideDishImage sideDishImage, List<DiscountEvent> discountEvents) {

        double totalDiscountRate = discountEvents.stream()
                .mapToDouble(DiscountEvent::getDiscountRate)
                .sum();

        return new SideDishCard(
                sideDish.getId(),
                sideDishImage.getImageUrl(),
                sideDish.getName(),
                sideDish.getDescription(),
                sideDish.getPrice() * (1.0 - totalDiscountRate),
                sideDish.getPrice(),
                discountEvents.stream().map(DiscountEvent::getTitle).collect(Collectors.toList())
        );
    }
}
