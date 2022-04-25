package team14.sidedish.event;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import team14.sidedish.eventplanner.EventPlannerDto;
import team14.sidedish.menu.MenuDto;
import team14.sidedish.salepolicy.DiscountPolicy;
import team14.sidedish.salepolicy.SalePolicy;

@Data
public class EventAndSalesDto {
	private final List<Event> events;
	private final List<SalePolicy> salePolicies;

	public EventAndSalesDto(List<Event> events, List<SalePolicy> salePolicies) {
		this.events = events;
		this.salePolicies = salePolicies;
	}

	/**
	 * 적용되는 이벤트가 여러개면, 이벤트에 적용된 차감액들을 모은다.
	 * @param category
	 * @param id
	 * @return
	 */
	public List<BigDecimal> getDeductibleAmounts(MenuDto.SubCategory category, EventPlannerDto.Id id) {
		return this.salePolicies.stream()
			.filter(salePolicy -> salePolicy.isEquals(id.getEventId()))
			.map(salePolicy -> {
				// 할인정책에 따른 할인가격 계산
				// DiscountPolicy 를 가지고 있어서, 문자열 할인정책으로 해당 객체에 할인퍼센트/금액 지정
				// 해당 정상가격에서 할인금액 반환
				DiscountPolicy discountPolicy = new DiscountPolicy(salePolicy.policy(), salePolicy.discountAmount());
				return discountPolicy.getDeductibleAmount(category.getOriginalPrice());
			}).collect(Collectors.toList());
	}

	public List<String> getEventBadges(EventPlannerDto.Id id) {
		return this.events.stream()
			.filter(event -> event.isEquals(id.getEventId()))
			.map(Event::title)
			.collect(Collectors.toList());
	}
}
