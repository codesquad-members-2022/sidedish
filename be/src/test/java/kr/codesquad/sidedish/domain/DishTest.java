package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.response.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DishTest {

    @Test
    @DisplayName("존재하지 않는 요리 카테고리 조회 시 DISH_TYPE_NOT_ALLOWED 예외가 발생한다.")
    void notHaveDishType() {
        // given
        String dishType = "한식";
        // when

        // then
        assertThatThrownBy(() -> Dish.stringToEnum(dishType))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorCode.DISH_TYPE_NOT_ALLOWED.getDetail());
    }
}
