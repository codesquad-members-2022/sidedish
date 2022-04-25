package com.codesquad.sidedish.other;

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
