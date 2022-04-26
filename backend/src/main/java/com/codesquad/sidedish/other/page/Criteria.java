package com.codesquad.sidedish.other.page;

import lombok.Getter;

@Getter
public class Criteria {

    private final int page;
    private final int size;

    public Criteria(int page, int size) {
        this.page = Math.max(page, 1);
        this.size = size;
    }

    public int getLimit() {
        return size * page + 1;
    }

    public int getOffset() {
        return size * (page - 1);
    }

}
