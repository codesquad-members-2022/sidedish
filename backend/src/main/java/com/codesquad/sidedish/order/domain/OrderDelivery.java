package com.codesquad.sidedish.order.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@ToString
@RequiredArgsConstructor
public class OrderDelivery {

    @Column("delivery_code")
    private final String code;

}
