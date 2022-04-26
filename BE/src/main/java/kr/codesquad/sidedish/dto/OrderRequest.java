package kr.codesquad.sidedish.dto;

public class OrderRequest {

    private String userEmail;
    private Long dishId;
    private int quantity;

    public OrderRequest() {
    }

    public OrderRequest(String userEmail, Long dishId, int quantity) {
        this.userEmail = userEmail;
        this.dishId = dishId;
        this.quantity = quantity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Long getDishId() {
        return dishId;
    }

    public int getQuantity() {
        return quantity;
    }
}
