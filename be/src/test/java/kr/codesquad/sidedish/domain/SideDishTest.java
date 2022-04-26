package kr.codesquad.sidedish.domain;

import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.response.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SideDishTest {

    @Test
    @DisplayName("존재하지 않는 반찬 카테고리 조회 시 SIDE_DISH_TYPE_NOT_ALLOWED 예외가 발생한다.")
    void notHaveDishType() {
        // given
        String sideDishType = "채소";
        // when

        // then
        assertThatThrownBy(() -> SideDish.stringToEnum(sideDishType))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorCode.SIDE_DISH_TYPE_NOT_ALLOWED.getDetail());
    }
}
