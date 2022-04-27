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
    private int totalAmount;

    @CreatedDate
    private LocalDateTime createdAt;
    private long sideDishId;
    private long memberId;

    public static OrderSheet of(int quantity, int totalAmount, long sideDishId, long memberId) {
        return new OrderSheet(0, quantity, totalAmount, null, sideDishId, memberId);
    }
}
