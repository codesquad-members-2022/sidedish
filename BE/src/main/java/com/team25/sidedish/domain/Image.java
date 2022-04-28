package com.team25.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Image {

    @Id
    private Long id;
    private String url;
    private Long productId;

    public Image(String url, Long productId) {
        this.url = url;
        this.productId = productId;
    }
}
