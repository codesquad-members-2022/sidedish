package com.terria.sidedish.domain;

import lombok.Getter;

@Getter
public class Category {

    private long id;
    private String title;
    private long parent;

    // FK;
    private long divisionId;
}
