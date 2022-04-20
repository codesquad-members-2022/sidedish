package kr.codesquad.sidedish.dto;

public class ResponseProduct {

	private int code;
	private String name;
	private String content;
	private int price;
	private int quantity;
	private String dishType;
	private String sideDishType;
	private String applyEvent;
	private String imgUrl;

	public ResponseProduct(int code, String name, String content, int price, int quantity,
		String dishType,
		String sideDishType, String applyEvent, String imgUrl) {
		this.code = code;
		this.name = name;
		this.content = content;
		this.price = price;
		this.quantity = quantity;
		this.dishType = dishType;
		this.sideDishType = sideDishType;
		this.applyEvent = applyEvent;
		this.imgUrl = imgUrl;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getDishType() {
		return dishType;
	}

	public String getSideDishType() {
		return sideDishType;
	}

	public String getApplyEvent() {
		return applyEvent;
	}

	public String getImgUrl() {
		return imgUrl;
	}
}
