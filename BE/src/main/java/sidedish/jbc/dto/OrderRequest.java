package sidedish.jbc.dto;


import sidedish.jbc.domain.MenuOrder;
import sidedish.jbc.domain.SaleType;

public class OrderRequest {

	private int userId;
	private String menuName;
	private int menuPrice;
	private SaleType saleType;
	private int fee;
	private int quantity;

	public OrderRequest() {
	}

	public OrderRequest(int userId, String menuName, int menuPrice,
		SaleType saleType, int fee, int quantity) {
		this.userId = userId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.saleType = saleType;
		this.fee = fee;
		this.quantity = quantity;
	}

	public MenuOrder toEntity() {
		return new MenuOrder(userId, menuName, menuPrice, saleType, fee, quantity);
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

	public SaleType getSaleType() {
		return saleType;
	}
}
