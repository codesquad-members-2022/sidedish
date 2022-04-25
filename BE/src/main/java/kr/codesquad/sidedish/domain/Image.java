package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Image {

    @Id
    private final Long imageId;
    private final Long itemId;
    private final String detailImages;

    public Image(Long imageId, Long itemId, String detailImages) {
        this.imageId = imageId;
        this.itemId = itemId;
        this.detailImages = detailImages;
    }
}
