package sidedish.web.dto.image;

import lombok.Getter;
import sidedish.domain.images.Image;

@Getter
public class ResponseImagesDto {
    private Long id;
    private String url;

    public ResponseImagesDto(Image image) {
        id = image.getId();
        url = image.getUrl();
    }
}
