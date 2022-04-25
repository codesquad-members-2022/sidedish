package sidedish.jbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Image {

	@Id
	private Long id;
	private long menuId;
	private String imagePath;
	private Integer isMainImage;

	@PersistenceConstructor
	public Image(Long id, long menuId, String imagePath, Integer isMainImage) {
		this.id = id;
		this.menuId = menuId;
		this.imagePath = imagePath;
		this.isMainImage = isMainImage;
	}

	public Image(long menuId, String imagePath, Integer isMainImage) {
		this.menuId = menuId;
		this.imagePath = imagePath;
		this.isMainImage = isMainImage;
	}

	public Long getId() {
		return id;
	}

	public long getMenuId() {
		return menuId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public Integer getIsMainImage() {
		return isMainImage;
	}

	@Override
	public String toString() {
		return "Image{" +
			"id=" + id +
			", menuId=" + menuId +
			", imagePath='" + imagePath + '\'' +
			", isMainImage=" + isMainImage +
			'}';
	}
}
