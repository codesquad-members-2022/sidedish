package team14.sidedish.menu;

import java.math.BigDecimal;
import java.util.List;

/**
 * 추천메뉴, 메뉴 객체들을 MenuDto, EventPlannerDto 에서 공통으로 이용하기 위한 타입
 */
public interface MenuModel {
	default Long getMenuId() {
		return null;
	}

	default BigDecimal getPrice() {
		return null;
	}

	void setDiscountedPrice(BigDecimal discountedPrice);

	void setEvent(List<String> events);
}
