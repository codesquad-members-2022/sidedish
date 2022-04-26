package team14.sidedish.eventplanner;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Map;

import lombok.ToString;

@ToString
@Table("SIDEDISH_EVENT_PLANNER")
public class EventPlanner {
	public static final String EVENT_PLANNER_KEY = "event";
	public static final String EVENT_PLANNER_KEY_MENU = "menu";
	private final Long menuId;
	private final Long eventId;
	private final LocalDate startDate;
	@Column("EVENT_DURATION")
	private final int duration;

	protected EventPlanner(Long menuId, Long eventId, LocalDate startDate, int duration) {
		this.menuId = menuId;
		this.eventId = eventId;
		this.startDate = startDate;
		this.duration = duration;
	}

	protected LocalDate getStartDate() {
		return startDate;
	}

	protected int getDuration() {
		return duration;
	}

	protected Map<String, Long> getMenuAndEvent() {
		return Map.of(EVENT_PLANNER_KEY_MENU, this.menuId, EVENT_PLANNER_KEY, this.eventId);
	}
}
