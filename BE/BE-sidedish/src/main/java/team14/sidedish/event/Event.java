package team14.sidedish.event;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("SIDEDISH_EVENTS")
public class Event {
	@Column("EVENT_ID")
	private final Long eventId;
	private final String eventTitle;

	protected static Event of(String eventTitle) {
		return new Event(null, eventTitle);
	}

	protected Event(Long eventId, String eventTitle) {
		this.eventId = eventId;
		this.eventTitle = eventTitle;
	}

	public String title() {
		return eventTitle;
	}

	public boolean isEquals(Long eventId) {
		return Objects.equals(this.eventId, eventId);
	}
}
