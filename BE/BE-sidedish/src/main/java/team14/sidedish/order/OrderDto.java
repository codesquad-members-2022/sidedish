package team14.sidedish.order;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OrderDto {
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Request {
		@NotNull(message = "menuId는 필수 값 입니다.")
		@Min(value = 1L, message = "menuId는 1 이상이어야 합니다.")
		private Long menuId;
		@Min(value = 1000, message = "최소 상품 금액 이상이어야 합니다.")
		private int oneOrderPrice;  // 1개의 주문 요청한 상품가격 (할인적용된)
		@Min(value = 1, message = "최소한의 적립금이 있어야 합니다.")
		private int savedCharge;
		@Min(0)
		private int deliveryCharge;
		@Min(value = 1, message = "최소 1개 이상 주문 해야 합니다.")
		private int countOfOrder;
		@Min(value = 900, message = "최소 주문금액 이상 이어야 합니다.")
		private int totalOrderAmount;

		public boolean isEqualsTotalOrderPrice(int totalPrice) {
			return (this.oneOrderPrice * countOfOrder) == totalPrice;
		}

		public boolean isEqualsDeliverCharge(int deliveryCharge) {
			return (this.deliveryCharge == deliveryCharge);
		}

		public boolean isEqualsSavedCharge(int savedCharge) {
			return (this.savedCharge == savedCharge);
		}
	}

	// 총 ~원의 결제금액이 완료 됐습니다. (적립급 : 원, 할인금액 : 원, 배송비: 원)
	@Data
	@AllArgsConstructor
	public static class Response {
		private int orderPrice;
		private int totalDiscountedPrice;
		private int savedCharge;
		private int deliveryCharge;
	}
}
