package com.sidedish.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	private Long productId;
	private Long memberId;
	private int quantity;
	private int price;

}
