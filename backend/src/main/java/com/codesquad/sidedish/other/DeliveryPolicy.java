package com.codesquad.sidedish.other;

public enum DeliveryPolicy {
    CAPITAL_DAYBREAK("서울 경기 새벽 배송", "DL001"),
    COUNTRY_PARCEL("전국 택배 배송", "DL002");

    private final String detail;
    private final String code;

    DeliveryPolicy(String detail, String code) {
        this.detail = detail;
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public String getCode() {
        return code;
    }
}
