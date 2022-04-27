package codesquad.sidedish.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ItemTest {
    @Test
    @DisplayName("reduceStock() 메서드를 호출하면 아이템의 재고가 인자만큼 감소해야 한다.")
    void reduceStockSuccessTest() {
        Item item = Item.builder().stock(10).build();
        item.reduceStock(3);
        assertThat(item.getStock()).isEqualTo(7);
    }

    @Test
    @DisplayName("reduceStock()의 인자로 현재 재고보다 더 많은 숫자가 들어오면 예외가 발생해야 한다.")
    void reduceStockFailureTest() {
        Item item = Item.builder().stock(10).build();

        assertThatThrownBy(() -> item.reduceStock(20))
                .isInstanceOf(IllegalArgumentException.class);
    }

}