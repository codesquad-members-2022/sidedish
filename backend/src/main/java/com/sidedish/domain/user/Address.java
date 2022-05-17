package com.sidedish.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@AllArgsConstructor
public class Address {
    private String city;
    private String zipcode;
    private String street;

    protected Address() {
    }
}
