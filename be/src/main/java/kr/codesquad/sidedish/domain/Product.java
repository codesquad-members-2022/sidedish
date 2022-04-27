package kr.codesquad.sidedish.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Getter
@Data
public class Product {

	@Id
	private final Integer id;
	private final String name;
	private final String content;
	private final Integer price;
	private final Integer quantity;
	private final String dishType;
	private final String sidedishType;
	private final String applyEvent;
	private final String imgUrl;
	private final Integer deliveryType;

	public boolean isSameDishType(String dishType) {
		return this.dishType == dishType;
	}

	public boolean isSameSideDishType(String sidedishType) {
		return this.sidedishType == sidedishType;
	}
}
