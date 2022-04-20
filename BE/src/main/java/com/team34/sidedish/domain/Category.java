package com.team34.sidedish.domain;

import java.util.List;

public class Category {

    private Long id;
    private String name;
    private boolean isEvent;
    private Category parent;
    private List<Category> children;
}
