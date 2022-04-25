package sidedish.jbc.domain;

import org.springframework.data.annotation.Id;

public class MenuOrder {

	@Id
	private Integer id;
	private int userId;
	private String menuName;
	private int menuPrice;
	private SaleType saleType;
	private int fee;
	private int quantity;

	public MenuOrder(Integer id, int userId, String menuName, int menuPrice,
		SaleType saleType, int fee, int quantity) {
		this.id = id;
		this.userId = userId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.saleType = saleType;
		this.fee = fee;
		this.quantity = quantity;
	}

	public MenuOrder(int userId, String menuName, int menuPrice, SaleType saleType, int fee,
		int quantity) {
		this(null, userId, menuName, menuPrice, saleType, fee, quantity);
	}

	public Integer getId() {
		return id;
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
