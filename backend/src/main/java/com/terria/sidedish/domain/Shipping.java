package com.terria.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class Shipping {

    @Id
    private long id;
    private String type;
}
