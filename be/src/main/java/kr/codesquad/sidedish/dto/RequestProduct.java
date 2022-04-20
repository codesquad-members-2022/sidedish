package kr.codesquad.sidedish.dto;

public class RequestProduct {

	private int id;
	private int quantity;

	public RequestProduct() {
	}

	public RequestProduct(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getId() {
		return id;
	}
}
