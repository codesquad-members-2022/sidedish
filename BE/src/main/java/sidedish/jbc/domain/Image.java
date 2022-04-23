package sidedish.jbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Image {

	@Id
	private Long id;
	private long menuId;
	private String imagePath;
	private boolean isMainImage;

	@PersistenceConstructor
	public Image(Long id, long menuId, String imagePath, boolean isMainImage) {
		this.id = id;
		this.menuId = menuId;
		this.imagePath = imagePath;
		this.isMainImage = isMainImage;
	}

	public Image(long menuId, String imagePath, boolean isMainImage) {
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

	public boolean getIsMainImage() {
		return isMainImage;
	}


}
