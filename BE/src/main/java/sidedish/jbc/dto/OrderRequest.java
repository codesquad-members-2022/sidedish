package sidedish.jbc.dto;


import io.swagger.annotations.ApiModelProperty;

public class OrderRequest {


	private int userId;
	@ApiModelProperty(value = "주문 수량")
	private int quantity;

	private OrderRequest() {
	}

	public OrderRequest(int userId, int quantity) {
		this.userId = userId;
		this.quantity = quantity;
	}


	public int getUserId() {
		return userId;
	}

	public int getQuantity() {
		return quantity;
	}

}
