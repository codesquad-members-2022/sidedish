package com.terria.sidedish.domain;

import lombok.Getter;

@Getter
public class SideDishImage {

    private long id;
    private String imageURL;
    private int imageSeq;

    // FK
    private long sideDishId;
}
