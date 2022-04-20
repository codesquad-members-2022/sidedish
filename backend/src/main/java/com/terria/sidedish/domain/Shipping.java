package com.terria.sidedish.domain;

import lombok.Getter;

@Getter
public class Shipping {

    private long id;
    private String type;
    private int fee;
    private int exemptionCondition;
}
