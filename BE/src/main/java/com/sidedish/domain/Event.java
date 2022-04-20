package com.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("event")
public class Event {

    @Id
    private Long id;
    private String name;
    private boolean progressFlag;

    public Event(Long id, String name, boolean progressFlag) {
        this.id = id;
        this.name = name;
        this.progressFlag = progressFlag;
    }
}
