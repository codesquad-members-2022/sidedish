package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.dto.ResponseProduct;

public class Product {

	private final int id;
	private final String name;
	private final String content;
	private final int price;
	private final int quantity;
	private final String dishType;
	private final String sideDishType;
	private final String applyEvent;
	private final String imgUrl;

	public Product(int id, String name, String content, int price, int quantity, String dishType,
		String sideDishType, String applyEvent, String imgUrl) {
		this.id = id;
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
		return new Product(product.getId(), product.getName(), product.getContent(),
			product.getPrice(), quantity,
			product.getDishType(), product.getSideDishType(), product.getApplyEvent(),
			product.getImgUrl());
	}

	public int getId() {
		return id;
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
		return new ResponseProduct(id, name, content, price, quantity, dishType, sideDishType,
			applyEvent, imgUrl);
	}

	public boolean isSameDishType(String dishType) {
		return this.dishType == dishType;
	}

	public boolean isSameSideDishType(String sideDishType) {
		return this.sideDishType == sideDishType;
	}
}
