package sidedish.jbc.dto;


import sidedish.jbc.domain.MenuOrder;

public class OrderRequest {

	private int userId;
	private String menuName;
	private int menuPrice; // 할인 적용된 가격
	private int fee;
	private int quantity;

	private OrderRequest() {
	}

	public OrderRequest(int userId, String menuName, int menuPrice, int fee, int quantity) {
		this.userId = userId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.fee = fee;
		this.quantity = quantity;
	}

	public MenuOrder toEntity() {
		return new MenuOrder(userId, menuName, menuPrice, fee, quantity);
	}

	public int getUserId() {
		return userId;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public int getFee() {
		return fee;
	}

	public int getQuantity() {
		return quantity;
	}
}
