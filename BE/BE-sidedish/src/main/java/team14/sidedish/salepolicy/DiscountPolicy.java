package team14.sidedish.salepolicy;

import java.math.BigDecimal;
import java.util.Arrays;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiscountPolicy {
	private final PolicyCategory title;
	private final BigDecimal amount;

	@RequiredArgsConstructor
	enum PolicyCategory {
		PERCENT("rate_discount"),
		AMOUNT("amount_discount");

		private final String name;

		private static PolicyCategory from(String title) {
			return Arrays.stream(values())
				.filter(policy -> policy.name.equals(title))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("the parameter has no policyCategory name"));
		}
	}
	public DiscountPolicy(String title, String amount) {
		this.title = PolicyCategory.from(title);
		this.amount = new BigDecimal(amount);
	}

	public BigDecimal getDeductibleAmount(BigDecimal price) {
		switch (this.title) {
			case AMOUNT:
				return this.amount;
			case PERCENT:
				return price.multiply(this.amount);
		}
		return BigDecimal.ONE;
	}
}
