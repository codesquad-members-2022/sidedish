package com.terria.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Member {

    @Id
    private long id;
    private String userId;
    private String password;
    private String name;
}
