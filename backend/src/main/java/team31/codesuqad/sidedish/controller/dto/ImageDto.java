package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.Images;

public class ImageDto {

    private Long imageId;
    private String imageType;
    private String url;

    public ImageDto(Images image) {
        this.imageId = image.getImageId();
        this.imageType = image.getType();
        this.url = image.getUrl();
    }

    public Long getImageId() {
        return imageId;
    }

    public String getImageType() {
        return imageType;
    }

    public String getUrl() {
        return url;
    }

}
