package team14.sidedish.order;

import java.util.function.Function;

import lombok.RequiredArgsConstructor;

/**
 * 메뉴상세보기, 주문시 안내 정보와 계산 로직
 */
@RequiredArgsConstructor
public enum OrderInfo {
	BASE_DELIVERY_CHARGE("기본배송비", "2,500원", zero -> 2500),
	SAVED_CHARGE("적립금", "", amount -> amount / 100),
	DELIVERY_INFO("배송정보", "서울 경기 새벽배송, 전국 택배 배송", regionNumber -> RegionModel.hasService(regionNumber) ? 1 : 0),
	DELIVERY_CHARGE("배송비", "2,500원(40,000원 이상 구매시 무료)", price -> price >= 40000 ? 0 : 2500);

	private final String title;
	private final String description;
	private final Function<Integer, Integer> infoResult;

	public int calculate(int amount) {
		return infoResult.apply(amount);
	}

	public String getDeliveryWay(int regionNumber) {
		return infoResult.apply(regionNumber) == 1 ? "새벽배송" : "전국 택배 배송";
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public static int getDeliveryFreeCondition() {
		return 40000;
	}

	public static int getDeliveryCharge() {
		return 2500;
	}
}
