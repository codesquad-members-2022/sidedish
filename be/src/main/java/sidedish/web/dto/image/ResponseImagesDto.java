package sidedish.web.dto.image;

import lombok.Getter;
import sidedish.domain.images.Images;

@Getter
public class ResponseImagesDto {
    private Long id;
    private String url;

    public ResponseImagesDto(Images image) {
        id = image.getId();
        url = image.getUrl();
    }
}
