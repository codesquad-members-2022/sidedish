package com.codesquad.sidedish.order.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

public class User {

    @Id
    private Integer id;
    private String username;
    private String password;

    @MappedCollection(idColumn = "USER_ID")
    private Set<Order> orders = new HashSet<>();

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
