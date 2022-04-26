package com.terria.sidedish.dto.response;

import com.terria.sidedish.domain.entity.aggregate.SideDish;
import com.terria.sidedish.domain.entity.reference.DiscountEvent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class SideDishCardResponse {


    @ApiModelProperty(required = true, value = "반찬 아이디")
    private long sideDishId;

    @ApiModelProperty(required = true, value = "반찬 이미지 url")
    private String imageUrl;

    @ApiModelProperty(required = true, value = "반찬 이름")
    private String name;

    @ApiModelProperty(required = true, value = "반찬 설명")
    private String description;

    @ApiModelProperty(required = true, value = "할인가")
    private int disCountPrice;

    @ApiModelProperty(required = true, value = "정상가")
    private int price;

    @ApiModelProperty(required = true, value = "배송정보")
    private String shippingInfo;

    @ApiModelProperty("할인 이벤트 목록")
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
