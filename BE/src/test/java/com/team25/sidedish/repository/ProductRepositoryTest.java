package com.team25.sidedish.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.team25.sidedish.domain.Product;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class ProductRepositoryTest {

    private static final Long CATEGORY_ID = 3L;
    private static final int CATEGORY_PRODUCT_COUNT = 1;
    private static final Long PRODUCT_ID = 6L;
    private static final Long PRODUCT_ID_NOT_EXIST = 7L;
    private static final String PRODUCT_NAME = "아이템6";
    private static final int PRODUCT_PRICE = 21800;
    private static final String PRODUCT_DESCRIPTION = "설명1";
    private static final int PRODUCT_STOCK = 600;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("카테고리 ID를 통해 해당하는 프로덕트 목록을 조회할 수 있다")
    void 카테고리ID로_프로덕트_조회_테스트() {

        // when
        Optional<List<Product>> result = productRepository.findProductsByCategoryId(
            CATEGORY_ID);

        // then
        assertThat(result).isPresent();
        assertThat(result.get()).hasSize(CATEGORY_PRODUCT_COUNT);
        assertThat(result.get().get(0).getName()).isEqualTo(PRODUCT_NAME);
        assertThat(result.get().get(0).getPrice()).isEqualTo(PRODUCT_PRICE);
        assertThat(result.get().get(0).getDescription()).isEqualTo(PRODUCT_DESCRIPTION);
        assertThat(result.get().get(0).getStock()).isEqualTo(PRODUCT_STOCK);
    }

    @Nested
    @DisplayName("프로덕트 ID에")
    class findByProductId {

        @Test
        @DisplayName("해당하는 프로덕트가 있으면 조회 할 수 있다")
        void 프로덕트_조회_가능_테스트() {

            // when
            Optional<Product> result = productRepository.findById(
                PRODUCT_ID);

            // then
            assertThat(result).isPresent();
            assertThat(result.get().getId()).isEqualTo(PRODUCT_ID);
            assertThat(result.get().getName()).isEqualTo(PRODUCT_NAME);
            assertThat(result.get().getPrice()).isEqualTo(PRODUCT_PRICE);
            assertThat(result.get().getDescription()).isEqualTo(PRODUCT_DESCRIPTION);
            assertThat(result.get().getStock()).isEqualTo(PRODUCT_STOCK);
        }

        @Test
        @DisplayName("해당하는 프로덕트가 없으면 조회 할 수 없다")
        void 프로덕트_조회_불가_테스트() {

            // when
            Optional<Product> result = productRepository.findById(
                PRODUCT_ID_NOT_EXIST);

            // then
            assertThat(result).isNotPresent();
        }
    }

    @Test
    @DisplayName("프로덕트를 업데이트 할 수 있다")
    void 프로덕트_업데이트_테스트() {

        // given
        int amountToDeliver = 10;
        Product product = productRepository.findById(PRODUCT_ID)
            .orElseThrow();

        // when
        int updatedStock = product.updateStock(10);
        productRepository.save(product);

        // then
        Product result = productRepository.findById(PRODUCT_ID)
            .orElseThrow();
        assertThat(result.getStock()).isEqualTo(updatedStock);
    }
}
