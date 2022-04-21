package com.sidedish.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Table("sidedish_price")
public class SideDishPrice {

    @Id
    private Long id;
    private Long sidedishId;
    private Integer price;
    private Integer discountRate;
    private String discountType;
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedDateTime;

    public SideDishPrice(Long id, Long sidedishId, Integer price, Integer discountRate,
        String discountType, LocalDateTime createdDateTime, LocalDateTime modifiedDateTime) {
        this.id = id;
        this.sidedishId = sidedishId;
        this.price = price;
        this.discountRate = discountRate;
        this.discountType = discountType;
        this.createdDateTime = createdDateTime;
        this.modifiedDateTime = modifiedDateTime;
    }
}
