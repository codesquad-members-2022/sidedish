package com.codesquad.sidedish.dish.dto;

import com.codesquad.sidedish.dish.domain.DishDiscount;
import com.codesquad.sidedish.other.DiscountPolicy;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DiscountResponse {

    private final String detail;
    private final String code;
    private final double rate;

    public static DiscountResponse from(DishDiscount dishDiscount) {
        DiscountPolicy discountPolicy = DiscountPolicy.from(dishDiscount.getCode());

        return new DiscountResponse(
            discountPolicy.getDetail(),
            discountPolicy.getCode(),
            discountPolicy.getRate()
        );
    }

    public static List<DiscountResponse> from(Set<DishDiscount> dishDiscounts) {
        return dishDiscounts.stream()
            .map(DiscountResponse::from)
            .collect(Collectors.toList());
    }
}
