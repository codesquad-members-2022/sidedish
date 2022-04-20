package com.terria.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class Category {

    @Id
    private long id;
    private String title;
    private long parent;
}
