package kr.codesquad.sidedish.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseProduct {

	private int code;
	private String name;
	private String content;
	private int price;
	private int quantity;
	private String dishType;
	private String sideDishType;
	private String applyEvent;
	private String imgUrl;
}
