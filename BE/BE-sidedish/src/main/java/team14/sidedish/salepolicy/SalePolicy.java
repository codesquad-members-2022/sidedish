package team14.sidedish.salepolicy;

import org.springframework.data.relational.core.mapping.Table;

@Table("SIDEDISH_SALE_POLICY")
public class SalePolicy {
	private final Long saleId;
	private final String saleTitle;
	private final String saleAmount;
	private final Long eventId;

	public static SalePolicy of(String saleTitle, String saleAmount, Long eventId) {
		return new SalePolicy(null, saleTitle, saleAmount, eventId);
	}

	protected SalePolicy(Long saleId, String saleTitle, String saleAmount, Long eventId) {
		this.saleId = saleId;
		this.saleTitle = saleTitle;
		this.saleAmount = saleAmount;
		this.eventId = eventId;
	}

	public boolean isEquals(Long eventId) {
		return this.eventId == eventId;
	}

	public String policy() {
		return saleTitle;
	}

	public String discountAmount() {
		return saleAmount;
	}
}
