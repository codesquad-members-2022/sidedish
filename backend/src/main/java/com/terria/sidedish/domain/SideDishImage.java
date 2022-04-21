package com.terria.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
@ToString
public class SideDishImage {

    @Id
    private long id;
    private String imageUrl;
    private int imageSeq;

    // FK
    private long sideDishId;
}
