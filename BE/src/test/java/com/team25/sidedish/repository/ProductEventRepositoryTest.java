package com.team25.sidedish.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.team25.sidedish.domain.Event;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class ProductEventRepositoryTest {

    private static final Long PRODUCT_ID = 1L;
    private static final int EVENT_COUNT = 2;
    private static final Long EVENT_1_ID  = 1L;
    private static final String EVENT_1_NAME  = "이벤트1";
    private static final double EVENT_1_DISCOUNT_RATE  = 0.2;
    private static final Long EVENT_2_ID  = 2L;
    private static final String EVENT_2_NAME  = "이벤트2";
    private static final double EVENT_2_DISCOUNT_RATE  = 0.1;


    @Autowired
    private ProductEventRepository productEventRepository;

    @Test
    @DisplayName("프로덕트 ID를 통해 해당하는 이벤트 목록을 조회할 수 있다")
    void 프로덕트ID로_이벤트_조회_테스트() {

        // when
        List<Event> result = productEventRepository.findEventsByProductId(
                PRODUCT_ID);

        // then
        assertThat(result).hasSize(EVENT_COUNT);
        assertThat(result.get(0).getId()).isEqualTo(EVENT_1_ID);
        assertThat(result.get(0).getName()).isEqualTo(EVENT_1_NAME);
        assertThat(result.get(0).getDiscountRate()).isEqualTo(EVENT_1_DISCOUNT_RATE);
        assertThat(result.get(1).getId()).isEqualTo(EVENT_2_ID);
        assertThat(result.get(1).getName()).isEqualTo(EVENT_2_NAME);
        assertThat(result.get(1).getDiscountRate()).isEqualTo(EVENT_2_DISCOUNT_RATE);

    }
}
