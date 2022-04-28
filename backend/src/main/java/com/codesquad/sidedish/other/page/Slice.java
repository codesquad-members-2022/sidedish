package com.codesquad.sidedish.other.page;

import java.util.List;
import lombok.Getter;

@Getter
public class Slice<T> {

    private final Boolean hasNext;
    private final List<T> data;

    public Slice() {
        this.hasNext = false;
        this.data = List.of();
    }

    public Slice(List<T> data, Criteria criteria) {
        int index = Math.min(data.size(), criteria.getSize());

        this.hasNext = data.size() > criteria.getSize();
        this.data = data.subList(0, index);
    }

}
