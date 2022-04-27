package com.sidedish.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Table("user_order")
public class UserOrder {

    @Id
    private Integer id;
    private Integer userId;
    private Integer sidedishId;
    private Integer quantity;
    private Integer totalPrice;
    private Integer fee;
    private Integer point;
    private LocalDateTime createdDatetime;
    private LocalDateTime modifiedDatetime;

}
