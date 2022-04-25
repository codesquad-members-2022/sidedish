package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.response.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum SideDishType {

    MEAT("고기"),
    NUTRITION("영양"),
    SEASON("제철"),
    CONVENIENCE("편리"),

    ;

    private final String type;

    public static SideDishType stringToEnum(String type) {
        return Arrays.stream(values())
                .filter(sideDishType -> sideDishType.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new CustomException(ErrorCode.SIDE_DISH_TYPE_NOT_ALLOWED));
    }
}
