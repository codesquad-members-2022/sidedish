package team14.sidedish.exhibition;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Duration;
import java.time.LocalDate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Table("SIDEDISH_EXHIBITIONS")
public class Exhibition {
	@Column("EXHIBITION_ID")
	private Long exhibitionId;
	@Column("EXHIBITION_TITLE")
	private String title;
	@Column("EXHIBITION_START")
	private LocalDate startAt;
	@Column("EXHIBITION_DURATION")
	private Duration duration;

	protected static Exhibition of(String title, LocalDate startAt, Duration duration) {
		return new Exhibition(null, title, startAt, duration);
	}

	protected Long getExhibitionId() {
		return exhibitionId;
	}

	protected String getTitle() {
		return title;
	}
}
