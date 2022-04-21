package sidedish.jbc.dto;

public class DetailMenuImages {

	private String imagePath;
	private int isMainImage;

	public DetailMenuImages(String imagePath, int isMainImage) {
		this.imagePath = imagePath;
		this.isMainImage = isMainImage;
	}

	public boolean isMain() {
		return isMainImage == 1;
	}

	public String getImagePath() {
		return imagePath;
	}

}
