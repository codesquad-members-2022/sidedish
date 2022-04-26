package team14.sidedish.event;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import team14.sidedish.salepolicy.SalePolicy;

@Table("SIDEDISH_EVENTS")
public class Event {
	@Id
	@Column("EVENT_ID")
	private final Long eventId;
	@Column("EVENT_TITLE")
	private final String eventTitle;

	@MappedCollection(idColumn = "EVENT_ID", keyColumn = "EVENT_ID")
	private List<SalePolicy> salePolicies = new ArrayList<>();

	protected static Event of(String eventTitle) {
		return new Event(null, eventTitle);
	}

	protected Event(Long eventId, String eventTitle) {
		this.eventId = eventId;
		this.eventTitle = eventTitle;
	}

	public Long getEventId() {
		return eventId;
	}

	public String title() {
		return eventTitle;
	}

	public List<SalePolicy> getSalePolicies() {
		return salePolicies;
	}

	public boolean isEquals(Long eventId) {
		return Objects.equals(this.eventId, eventId);
	}
}
