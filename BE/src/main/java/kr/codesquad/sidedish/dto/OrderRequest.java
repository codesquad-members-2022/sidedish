package kr.codesquad.sidedish.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class OrderRequest {

    @Email
    private String userEmail;
    @Min(1)
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
