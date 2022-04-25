package com.sidedish.api.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @NotNull
    private Long id;

    @Min(1)
    private int quantity;
}
