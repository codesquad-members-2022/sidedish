package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.dto.ResponseProduct;

public class Product {

	private int code;
	private String name;
	private String content;
	private int price;
	private int quantity;
	private String dishType;
	private String sideDishType;
	private String applyEvent;
	private String imgUrl;

	public Product(String name, String content, int price, int quantity, String dishType,
		String sideDishType, String applyEvent, String imgUrl) {
		this.name = name;
		this.content = content;
		this.price = price;
		this.quantity = quantity;
		this.dishType = dishType;
		this.sideDishType = sideDishType;
		this.applyEvent = applyEvent;
		this.imgUrl = imgUrl;
	}

	public static Product updateQuantity(Product product, int quantity) {
		return new Product(product.getName(), product.getContent(), product.getPrice(), quantity,
			product.getDishType(), product.getSideDishType(), product.getApplyEvent(),
			product.getImgUrl());
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

	public ResponseProduct createResponseProduct() {
		return new ResponseProduct(code, name, content, price, quantity, dishType, sideDishType,
			applyEvent, imgUrl);
	}

	public boolean isSameDishType(String dishType) {
		return this.dishType == dishType;
	}

	public boolean isSameSideDishType(String sideDishType) {
		return this.sideDishType == sideDishType;
	}
}
