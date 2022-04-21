package sidedish.jbc.domain;

import org.springframework.data.annotation.PersistenceConstructor;

public class Image {

	private Long id;
	private long menuId;
	private String imagePath;
	private int isMainImage;

	@PersistenceConstructor
	public Image(Long id, long menuId, String imagePath, int isMainImage) {
		this.id = id;
		this.menuId = menuId;
		this.imagePath = imagePath;
		this.isMainImage = isMainImage;
	}

	public Image(long menuId, String imagePath, int isMainImage) {
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

	public int getIsMainImage() {
		return isMainImage;
	}


}
