package com.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Getter
@Table("event")
public class Event {

    @Id
    private Integer id;
    private String name;
    private boolean progressFlag;
}
