package com.codesquad.sidedish.other;

import com.codesquad.sidedish.exception.ErrorCode;
import com.codesquad.sidedish.exception.unchecked.NotFoundException;
import java.util.Arrays;
import lombok.Getter;

@Getter
public enum DiscountPolicy {
    LAUNCHING("런칭특가", "DC001", 0.2),
    EVENT("이벤트특가", "DC002", 0.1);

    private final String detail;
    private final String code;
    private final double rate;

    DiscountPolicy(String detail, String code, double rate) {
        this.detail = detail;
        this.code = code;
        this.rate = rate;
    }

    public static DiscountPolicy from(String code) {
        return Arrays.stream(DiscountPolicy.values())
            .filter(policy -> policy.getCode().equals(code))
            .findFirst()
            .orElseThrow(() -> new NotFoundException(ErrorCode.DISCOUNT_NOT_FOUND));
    }

}
