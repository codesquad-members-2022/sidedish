package team14.sidedish.event;

import lombok.ToString;

@ToString
public class OngoingEventInfo {
	private final Long eventId;
	private final String eventTitle;
	private final String saleTitle;
	private final String saleAmount;

	protected OngoingEventInfo(Long eventId, String eventTitle, String saleTitle, String saleAmount) {
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.saleTitle = saleTitle;
		this.saleAmount = saleAmount;
	}

	protected Long getEventId() {
		return eventId;
	}

	protected String getEventTitle() {
		return eventTitle;
	}

	protected String getSaleTitle() {
		return saleTitle;
	}

	protected String getSaleAmount() {
		return saleAmount;
	}
}
