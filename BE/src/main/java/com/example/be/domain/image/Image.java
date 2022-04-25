package com.example.be.domain.image;

import org.springframework.data.relational.core.mapping.Table;

@Table("images")
public class Image {

    private Long imageId;
    private String url;
}
