package kr.codesquad.sidedish.dto;

import java.time.LocalDateTime;

public class Reciept {

    private String userEmail;
    private String dishName;
    private int quantity;
    private int totalPrice;
    private LocalDateTime orderPlacedAt;


    public Reciept(String userEmail, String dishName, int quantity, int totalPrice) {
        this.userEmail = userEmail;
        this.dishName = dishName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderPlacedAt = LocalDateTime.now();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getDishName() {
        return dishName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getOrderPlacedAt() {
        return orderPlacedAt;
    }
}
