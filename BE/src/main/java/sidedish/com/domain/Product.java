package sidedish.com.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {

	private Long id;
	private List<Image> image;
	private String productName;
	private String description;
	private long fixedPrice;
	private long originalPrice;
	private DisCountPolicy disCountPolicy;

}
