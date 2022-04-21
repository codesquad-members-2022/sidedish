package com.codesquad.sidedish.other.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@AllArgsConstructor
@ToString
public class Delivery {

    @Id
    @Column("delivery_id")
    private Integer id;

    private final String detail;
}
