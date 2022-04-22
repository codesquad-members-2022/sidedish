package com.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("event")
public class Event {

    @Id
    private Integer id;
    private String name;
    private boolean progressFlag;
}
