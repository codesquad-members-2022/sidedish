package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.response.ErrorCode;
import lombok.Getter;

@Getter
public enum Delivery {
	ALL_WAY("서울 경기 새벽 배송, 전국 택배 배송"),
	NATIONWIDE("서울 경기 새벽 배송"),
	EARLY_MORNING("전국 택배 배송"),

	;


	private String deliveryInfo;
	private String value;

	Delivery(String value) {
		this.value = value;
	}

	public static Delivery convertInfo(String deliveryInfo) {
		switch (deliveryInfo) {
			case "새벽배송,전국택배":
				return ALL_WAY;
			case "전국택배":
				return NATIONWIDE;
			case "새벽배송":
				return EARLY_MORNING;
		}
		throw new CustomException(ErrorCode.DELIVERY_INFORMATION_NOT_CORRECT);
	}
}
