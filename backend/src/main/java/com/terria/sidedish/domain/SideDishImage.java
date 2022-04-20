package com.terria.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class SideDishImage {

    @Id
    private long id;
    private String imageURL;
    private int imageSeq;

    // FK
    private long sideDishId;
}
