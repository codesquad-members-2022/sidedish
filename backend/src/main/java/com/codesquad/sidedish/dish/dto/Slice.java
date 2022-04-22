package com.codesquad.sidedish.dish.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class Slice<T> {

    private final List<T> data;
    private final Boolean hasNext;

    public Slice(List<T> data) {
        // TODO : slice 구현
        this.data = data;
        this.hasNext = false;
    }
}
