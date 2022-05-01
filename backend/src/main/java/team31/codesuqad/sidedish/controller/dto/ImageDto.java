package team31.codesuqad.sidedish.controller.dto;

import team31.codesuqad.sidedish.domain.Image;
import team31.codesuqad.sidedish.type.ImageType;

public class ImageDto {

    private final Long imageId;
    private final ImageType imageType;
    private final String url;

    public ImageDto(Image image) {
        this.imageId = image.getImageId();
        this.imageType = image.getType();
        this.url = image.getUrl();
    }

    public Long getImageId() {
        return imageId;
    }

    public ImageType getImageType() {
        return imageType;
    }

    public String getUrl() {
        return url;
    }

}
