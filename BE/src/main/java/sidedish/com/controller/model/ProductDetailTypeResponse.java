package sidedish.com.controller.model;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sidedish.com.domain.Image;

@Getter
@AllArgsConstructor
public class ProductDetailTypeResponse {

	private Long id;
	private List<Image> images;
	private String productName;
	private String description;
	private long fixedPrice;
	private long originalPrice;
	private String event;
	private Long mileage;
	private String deliveryInfo;
	private Long deliveryCharge;
	private Long freeDeliveryOverAmount;

}
