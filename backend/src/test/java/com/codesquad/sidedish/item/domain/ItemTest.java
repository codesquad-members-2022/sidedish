package com.codesquad.sidedish.item.domain;

import com.codesquad.sidedish.item.exception.OutOfStockException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ItemTest {

    @Test
    @DisplayName("상품을 주문하면 재고가 줄어든다")
    void removeStock() {
        // given
        Item item = createItem();
        int orderAmount = 10;
        // when
        item.sold(orderAmount);
        // then
        assertThat(item.getStock()).isZero();
    }

    @Test
    @DisplayName("재고보다 많이 상품을 주문하면 예외가 발생한다")
    void removeStockFail() {
        // given
        Item item = createItem();
        int orderAmount = 11;
        // then
        assertThatThrownBy(() -> item.sold(orderAmount))
                .isInstanceOf(OutOfStockException.class);
    }

    @Test
    @DisplayName("구매 금액의 1%가 적립금으로 계산된다")
    void calculatePoint() {
        // given
        Item item = createItem();
        // when
        Integer point = item.calculatePoint();
        // then
        assertThat(point).isEqualTo(50);
    }

    private Item createItem() {
        int stock = 10;
        int price = 5000;
        return new Item(1, "testItem", "테스트", price, stock, "link", "none", 0);
    }
}
