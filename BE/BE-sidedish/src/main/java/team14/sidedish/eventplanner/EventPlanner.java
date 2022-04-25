package team14.sidedish.eventplanner;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

import lombok.ToString;

@ToString
@Table("SIDEDISH_EVENT_PLANNER")
public class EventPlanner {
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
}
