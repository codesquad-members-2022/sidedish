package com.codesquad.sidedish.dish.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@ToString
public class DishDiscount {

    @Column("discount_code")
    private String code;

}
