package com.team34.sidedish.domain;

import org.springframework.data.annotation.Id;

public class DishImage {

    @Id
    private Long id;

    private Long dishId;
    private String path;

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "DishImage{" +
            "id=" + id +
            ", dishId=" + dishId +
            ", path='" + path + '\'' +
            '}';
    }
}
