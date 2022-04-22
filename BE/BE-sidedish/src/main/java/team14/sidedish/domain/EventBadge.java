package team14.sidedish.domain;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class EventBadge {
	@Id
	private final Long badgeId;
	private final String title;

	public static EventBadge of(String title) {
		return new EventBadge(null, title);
	}

	public EventBadge withId(Long id) {
		return new EventBadge(id, this.title);
	}
}
