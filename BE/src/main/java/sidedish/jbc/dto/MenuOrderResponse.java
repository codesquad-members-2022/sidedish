package sidedish.jbc.dto;

import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuOrder;

public class MenuOrderResponse {

	//todo 유저의 아이디를 통해 유저 주소, 유저 이름을 내려야 함
	private int userId;
	private String menuName;
	private int price;
	private int salePrice;
	private int fee;
	private int quantity;

	public MenuOrderResponse(MenuOrder menuOrder, Menu menu) {
		this.userId = menuOrder.getUserId();
		this.menuName = menuOrder.getMenuName();
		this.price = menuOrder.getMenuPrice();
		this.salePrice = price - price * menuOrder.getSaleType().getSalePercentage() / 100;
		this.fee = menuOrder.getFee();
		this.quantity = menu.getStock() - menuOrder.getQuantity();
	}


	public int getUserId() {
		return userId;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getPrice() {
		return price;
	}

	public int getFee() {
		return fee;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getSalePrice() {
		return salePrice;
	}
}
