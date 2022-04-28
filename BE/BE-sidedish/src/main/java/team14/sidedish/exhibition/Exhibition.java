package team14.sidedish.exhibition;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Duration;
import java.time.LocalDate;

@Table("SIDEDISH_EXHIBITIONS")
public class Exhibition {
	@Column("EXHIBITION_ID")
	private final Long exhibitionId;
	@Column("EXHIBITION_TITLE")
	private final String title;
	@Column("EXHIBITION_START")
	private final LocalDate startAt;
	@Column("EXHIBITION_DURATION")
	private final Duration duration;

	protected static Exhibition of(String title, LocalDate startAt, Duration duration) {
		return new Exhibition(null, title, startAt, duration);
	}

	protected Exhibition(Long exhibitionId, String title, LocalDate startAt, Duration duration) {
		this.exhibitionId = exhibitionId;
		this.title = title;
		this.startAt = startAt;
		this.duration = duration;
	}

	protected Long getExhibitionId() {
		return exhibitionId;
	}

	protected String getTitle() {
		return title;
	}
}
