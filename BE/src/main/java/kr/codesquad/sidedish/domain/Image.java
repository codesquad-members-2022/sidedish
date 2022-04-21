package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Image {

    @Id
    private final Long image_id;
    private final Long item_id;
    private final String detail_images;

    public Image(Long image_id, Long item_id, String detail_images) {
        this.image_id = image_id;
        this.item_id = item_id;
        this.detail_images = detail_images;
    }

    public Long getImage_id() {
        return image_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public String getDetail_images() {
        return detail_images;
    }
}
