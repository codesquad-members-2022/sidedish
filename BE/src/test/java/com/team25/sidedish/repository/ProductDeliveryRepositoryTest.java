package com.team25.sidedish.repository;


import static org.assertj.core.api.Assertions.assertThat;

import com.team25.sidedish.domain.Delivery;
import com.team25.sidedish.domain.DeliveryType;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class ProductDeliveryRepositoryTest {

    private static final Long PRODUCT_ID = 1L;
    private static final int DELIVERY_COUNT = 2;
    private static final Long DELIVERY_1_ID  = 1L;
    private static final String DELIVERY_1_REGION  = "전국";
    private static final DeliveryType DELIVERY_1_TYPE  = DeliveryType.NORMAL;
    private static final Long DELIVERY_2_ID  = 2L;
    private static final String DELIVERY_2_REGION  = "서울";
    private static final DeliveryType DELIVERY_2_TYPE  = DeliveryType.DAWN;

    @Autowired
    private ProductDeliveryRepository productDeliveryRepository;

    @Test
    @DisplayName("프로덕트 ID를 통해 해당하는 딜리버리 목록을 조회할 수 있다")
    void 프로덕트ID로_딜리버리_조회_테스트() {

        Optional<List<Delivery>> result = productDeliveryRepository.findDeliveriesByProductId(PRODUCT_ID);

        assertThat(result).isPresent();
        assertThat(result.get()).hasSize(DELIVERY_COUNT);
        assertThat(result.get().get(0).getId()).isEqualTo(DELIVERY_1_ID);
        assertThat(result.get().get(0).getRegion()).isEqualTo(DELIVERY_1_REGION);
        assertThat(result.get().get(0).getType()).isEqualTo(DELIVERY_1_TYPE);
        assertThat(result.get().get(1).getId()).isEqualTo(DELIVERY_2_ID);
        assertThat(result.get().get(1).getRegion()).isEqualTo(DELIVERY_2_REGION);
        assertThat(result.get().get(1).getType()).isEqualTo(DELIVERY_2_TYPE);
    }
}
