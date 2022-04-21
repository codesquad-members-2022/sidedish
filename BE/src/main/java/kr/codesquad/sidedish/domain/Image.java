package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Image {

    @Id
    private final Long id;
    private final Long banchan_id;
    private final String detail_images;

    public Image(Long id, Long banchan_id, String detail_images) {
        this.id = id;
        this.banchan_id = banchan_id;
        this.detail_images = detail_images;
    }

    public Long getId() {
        return id;
    }

    public Long getBanchan_id() {
        return banchan_id;
    }

    public String getDetail_images() {
        return detail_images;
    }
}
