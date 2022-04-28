package codesquad.sidedish.domain.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


@DisplayName("DiscountPolicy 클래스의")
class DiscountPolicyTest {

    @Test
    @DisplayName("calculateDiscountedPrice 메서드는 할인된 가격을 반환해야 한다.")
    void calculateTest() {
        int itemPrice = 10000;
        DiscountPolicy discountPolicy = new DiscountPolicy("이벤트 특가", 0.1);

        int discountedPrice = discountPolicy.calculateDiscountedPrice(itemPrice);
        assertThat(discountedPrice).isEqualTo(9000);
    }

}