package team14.sidedish.image;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.ToString;

@ToString
@Table("SIDEDISH_IMAGE")
public class Image {
	@Column("MENU_IMAGE_URL")
	private final String url;
	@Column("IMAGE_MENU_ID")
	private final Long menuId;
	@Column("IMAGE_FILE_TYPE")
	private  String fileType;
	@Column("IMAGE_FILE_SIZE")
	private String fileSize;

	protected Image(String url, Long menuId, String fileType, String fileSize) {
		this.url = url;
		this.menuId = menuId;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}

	public String getUrl() {
		return url;
	}
}
