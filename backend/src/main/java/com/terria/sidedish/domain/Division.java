package com.terria.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Division {

    @Id
    private long id;
    private String title;
}
