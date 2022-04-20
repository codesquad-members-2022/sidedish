package kr.codesquad.sidedish.dto;

public class RequestProduct {

	private int quantity;

	public RequestProduct() {
	}

	public RequestProduct(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}
}
