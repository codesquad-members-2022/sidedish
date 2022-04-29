package com.team35.sidedish.dto.response.sidedish;

import com.team35.sidedish.domain.entity.aggregate.SideDish;
import com.team35.sidedish.domain.entity.reference.DiscountEvent;
import com.team35.sidedish.domain.entity.reference.SideDishImage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@ApiModel
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SideDishDetailResponse {

    @ApiModelProperty(required = true, value = "반찬 아이디")
    private long sideDishId;

    @ApiModelProperty(required = true, value = "반찬 이미지 url 3개")
    private List<String> imageUrls;

    @ApiModelProperty(required = true, value = "반찬 이름")
    private String name;

    @ApiModelProperty(required = true, value = "반찬 설명")
    private String description;

    @ApiModelProperty(required = true, value = "할인가")
    private int disCountPrice;

    @ApiModelProperty(required = true, value = "정상가")
    private int price;

    @ApiModelProperty(required = true, value = "재고수량")
    private int stock;

    @ApiModelProperty(required = true, value = "적립금")
    private int accumulatedAmount;

    @ApiModelProperty(required = true, value = "배송정보")
    private String shippingInfo;

    @ApiModelProperty(required = true, value = "배송비")
    private int shippingFee;

    @ApiModelProperty(required = true, value = "배송비 무료조건")
    private int exemptionCondition;

    @ApiModelProperty("할인 이벤트 목록")
    private List<DiscountEventResponse> discountEventResponses;

    public static SideDishDetailResponse from(SideDish sideDish, List<DiscountEvent> discountEvents) {

        return new SideDishDetailResponse(
                sideDish.getId(),
                sideDish.getSideDishImages().stream()
                        .map(SideDishImage::getImageUrl)
                        .collect(Collectors.toList()),
                sideDish.getName(),
                sideDish.getDescription(),
                getDiscountPrice(sideDish, discountEvents),
                sideDish.getPrice(),
                sideDish.getStock(),
                getAccrualAmount(sideDish),
                sideDish.getShippingInfo(),
                sideDish.getShippingFee(),
                sideDish.getExemptionCondition(),
                discountEvents.stream()
                        .map(DiscountEventResponse::from)
                        .collect(Collectors.toList())
        );
    }

    private static int getDiscountPrice(SideDish sideDish, List<DiscountEvent> discountEvents) {
        double totalDiscountRate = discountEvents.stream()
                .mapToDouble(DiscountEvent::getDiscountRate)
                .sum();

        return (int) (sideDish.getPrice() * (1.0 - totalDiscountRate)) / 10 * 10;
    }

    private static int getAccrualAmount(SideDish sideDish) {
        return (int) (sideDish.getPrice() * sideDish.getAccrualRate());
    }
}
