package team14.sidedish.order;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * OrderInfo의 DeliverInfo에 대한 새벽배송 가능한 지역정보
 */
@Getter
@RequiredArgsConstructor
public enum RegionModel {
	SEOUL("서울", "01", 1),
	GYEONGGI_DO("경기도", "02", 2);

	private final String regionName;
	private final String regionCode;
	private final int codeNumber;

	public static boolean hasService(int regionCode) {
		return Arrays.stream(values())
			.anyMatch(model -> model.codeNumber == regionCode);
	}
}
