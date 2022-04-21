package com.team34.sidedish.domain;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

public class Member {

    @Id
    private Long id;

    private String name;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
