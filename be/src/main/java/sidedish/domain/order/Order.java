package sidedish.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import sidedish.domain.dish.Dish;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	private Long id;
	private Long dishId;
	private int orderQuantity;
	private int totalPrice;
	private boolean deliveryFee;
}
