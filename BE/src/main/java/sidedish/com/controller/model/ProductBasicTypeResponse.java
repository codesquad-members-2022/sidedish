package sidedish.com.controller.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductBasicTypeResponse {

	private Long id;
	private String image;
	private String productName;
	private String description;
	private long fixedPrice;
	private long originalPrice;
	private String event;

}
