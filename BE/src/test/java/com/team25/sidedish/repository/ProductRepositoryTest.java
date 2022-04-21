package com.team25.sidedish.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.team25.sidedish.domain.Product;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class ProductRepositoryTest {
    private static final Long CATEGORY_ID = 3L;
    private static final int CATEGORY_PRODUCT_COUNT = 1;
    private static final String PRODUCT_NAME = "아이템6";
    private static final int PRODUCT_PRICE = 21800;
    private static final String PRODUCT_DISCRIPTION = "설명1";
    private static final int PRODUCT_STOCK = 600;


    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("카테고리 ID를 통해 해당하는 프로덕트 목록을 조회할 수 있다")
    void 카테고리ID로_프로덕트_조회_테스트() {

        // when
        Optional<List<Product>> result = productRepository.findProductsByCategoryId(
            CATEGORY_ID);

        assertThat(result).isPresent();
        assertThat(result.get()).hasSize(CATEGORY_PRODUCT_COUNT);
        assertThat(result.get().get(0).getName()).isEqualTo(PRODUCT_NAME);
        assertThat(result.get().get(0).getPrice()).isEqualTo(PRODUCT_PRICE);
        assertThat(result.get().get(0).getDiscription()).isEqualTo(PRODUCT_DISCRIPTION);
        assertThat(result.get().get(0).getStock()).isEqualTo(PRODUCT_STOCK);
    }
}
