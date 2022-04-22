package com.terria.sidedish.dto.response;

import com.terria.sidedish.domain.entity.reference.DiscountEvent;
import com.terria.sidedish.domain.entity.reference.SideDish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class SideDishCardResponse {

    private long sideDishId;
    private String imageUrl;
    private String name;
    private String description;
    private int disCountPrice;
    private int price;
    private String shippingInfo;
    private List<DiscountEventResponse> discountEventResponses;

    public static SideDishCardResponse from(SideDish sideDish, List<DiscountEvent> discountEvents) {

        double totalDiscountRate = discountEvents.stream()
                .mapToDouble(DiscountEvent::getDiscountRate)
                .sum();

        return new SideDishCardResponse(
                sideDish.getId(),
                sideDish.getSideDishImages().get(0).getImageUrl(),
                sideDish.getName(),
                sideDish.getDescription(),
                (int) (sideDish.getPrice() * (1.0 - totalDiscountRate)) / 10 * 10,
                sideDish.getPrice(),
                sideDish.getShippingInfo(),
                discountEvents.stream()
                        .map(DiscountEventResponse::from)
                        .collect(Collectors.toList())
        );
    }
}
