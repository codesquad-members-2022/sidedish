package com.terria.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class SideDishImage {

    @Id
    private long id;
    private String imageURL;
    private int imageSeq;

    // FK
    private long sideDishId;
}
