package sidedish.domain.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import sidedish.domain.item.Item;
import sidedish.web.dto.order.RequestOrderDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private Long id;
    private Long memberId;
    private Long itemId;
    private int orderQuantity;
    private int totalPrice;

    public Order(Item item, int orderQuantity) {
        this.itemId = item.getId();
        this.orderQuantity = orderQuantity;
        this.totalPrice = calculateTotalPrice(item.getPrice(), item.getDiscountRate(), orderQuantity);
    }

    private int calculateTotalPrice(int price, double discountRate,int quantity) {
        return (int)(price * discountRate) * quantity;
    }
}
