package com.example.be.domain;

import org.springframework.data.relational.core.mapping.Table;

@Table("images")
public class Image {

    private Long imageId;
    private String url;
}
