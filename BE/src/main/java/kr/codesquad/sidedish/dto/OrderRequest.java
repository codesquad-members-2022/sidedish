package kr.codesquad.sidedish.dto;

public class OrderRequest {

    private String userEmail;
    private int quantity;

    public OrderRequest() {
    }

    public OrderRequest(String userEmail, int quantity) {
        this.userEmail = userEmail;
        this.quantity = quantity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getQuantity() {
        return quantity;
    }
}
