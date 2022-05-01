package com.codesquad.sidedish.other;

import com.codesquad.sidedish.exception.ErrorCode;
import com.codesquad.sidedish.exception.unchecked.BusinessException;
import java.util.Arrays;
import lombok.Getter;

@Getter
public enum DeliveryPolicy {
    CAPITAL_DAYBREAK("서울 경기 새벽 배송", "DL001"),
    COUNTRY_PARCEL("전국 택배 배송", "DL002");

    private final String detail;
    private final String code;

    DeliveryPolicy(String detail, String code) {
        this.detail = detail;
        this.code = code;
    }

    public static DeliveryPolicy from(String code) {
        return Arrays.stream(DeliveryPolicy.values())
            .filter(policy -> policy.getCode().equals(code))
            .findAny()
            .orElseThrow(() -> new BusinessException(ErrorCode.DELIVERY_NOT_FOUND));
    }

}
