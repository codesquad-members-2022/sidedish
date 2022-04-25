package com.codesquad.sidedish.other;

import java.util.Arrays;

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
            .orElseThrow(() -> new IllegalArgumentException("일치하는 할인 코드가 존재하지 않습니다."));
    }

    public String getDetail() {
        return detail;
    }

    public String getCode() {
        return code;
    }

    public double getRate() {
        return rate;
    }
}
