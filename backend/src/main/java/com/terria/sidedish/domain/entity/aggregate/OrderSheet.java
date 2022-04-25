package com.terria.sidedish.domain.entity.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class OrderSheet {

    @Id
    private long id;
    private int quantity;
    private double totalAmount;

    @CreatedDate
    private LocalDateTime createdAt;

    // FK
    private long sideDishId;
    private long memberId;
}
