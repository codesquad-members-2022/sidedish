package com.codesquad.sidedish.dish.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@ToString
@Table("dish_recommend")
public class RecommendRef {

    private int recommendeeId;
}
