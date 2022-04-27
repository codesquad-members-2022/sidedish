package com.codesquad.sidedish.item.domain;

import com.codesquad.sidedish.item.exception.OutOfStockException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item;
    private int stock;
    private int price;

    @BeforeEach
    void setUp() {
        stock = 10;
        price = 5000;
        item = new Item(1, "testItem", "테스트", price, stock, "link", "none", 0);
    }

    @Test
    @DisplayName("상품을 주문하면 재고가 줄어든다")
    void removeStock() {
        // given
        int orderAmount = stock;
        // when
        item.removeStock(orderAmount);
        // then
        assertThat(item.getStock()).isEqualTo(stock - orderAmount);
    }

    @Test
    @DisplayName("재고보다 많이 상품을 주문하면 예외가 발생한다")
    void removeStockFail() {
        // given
        int orderAmount = stock + 1;
        // then
        assertThrows(OutOfStockException.class,
                () -> item.removeStock(orderAmount));
    }

    @Test
    @DisplayName("구매 금액의 1%가 적립금으로 계산된다")
    void calculatePoint() {
        // when
        Integer point = item.calculatePoint();
        // then
        assertThat(point).isEqualTo((int) ((double) price * 0.01));
    }
}
