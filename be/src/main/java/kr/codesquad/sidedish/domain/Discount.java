package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.response.ErrorCode;
import lombok.Getter;

@Getter
public enum Discount {

	SUPER_SALE(0.7),
	LAUNCHING(0.8),
	EVENT(0.9),
	NO_SALE(1.0);

	private String applyEvent;
	private double value;

	Discount(double value) {
		this.value = value;
	}


	public static Discount setSaleType(String applyEvent) {
		switch (applyEvent) {
			case "런칭특가,이벤트특가":
				return SUPER_SALE;
			case "런칭특가":
				return LAUNCHING;
			case "이벤트특가":
				return EVENT;
			case "":
				return NO_SALE;
		}
		throw new CustomException(ErrorCode.DISH_TYPE_NOT_ALLOWED);
	}
}
