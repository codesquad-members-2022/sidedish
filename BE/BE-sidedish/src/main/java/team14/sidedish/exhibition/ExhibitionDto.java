package team14.sidedish.exhibition;

import lombok.Data;

@Data
public class ExhibitionDto {
	private final Long exhibitionId;
	private final String title;

	public ExhibitionDto(Exhibition exhibition) {
		this.exhibitionId = exhibition.getExhibitionId();
		this.title = exhibition.getTitle();
	}
}
