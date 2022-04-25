package sidedish.jbc.dto;

import sidedish.jbc.domain.MenuOrder;

public class MenuOrderResponse {

	//todo 유저의 아이디를 통해 유저 주소, 유저 이름을 내려야 함
	private int userId;
	private String menuName;
	private int menuPrice;
	private int fee;
	private int quantity;

	public MenuOrderResponse(MenuOrder menuOrder) {
		this.userId = menuOrder.getUserId();
		this.menuName = menuOrder.getMenuName();
		this.menuPrice = menuOrder.getMenuPrice();
		this.fee = menuOrder.getFee();
		this.quantity = menuOrder.getQuantity();
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
