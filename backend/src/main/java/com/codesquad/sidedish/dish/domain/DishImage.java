package com.codesquad.sidedish.dish.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class DishImage {

    private final String imagePath;
    private final Integer sequence;
}
