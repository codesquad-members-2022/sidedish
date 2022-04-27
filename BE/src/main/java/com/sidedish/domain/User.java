package com.sidedish.domain;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Table("user")
public class User {

    @Id
    private Integer id;
    private String email;

}
