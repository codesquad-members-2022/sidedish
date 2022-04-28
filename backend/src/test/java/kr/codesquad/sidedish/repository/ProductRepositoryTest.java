package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);

    @Test
    @DisplayName("테스트 DB에서 조건 없이 제품 목록을 조회하면 21건의 제품이 조회되어야 한다.")
    void findAll() {
        List<Product> products = productRepository.findAllByCategoryIdAndThemeId(null, null,
                null, 0L, 30);

        assertThat(products).hasSize(21);
        products.forEach(
                product -> {
                    logger.info(product.toString());
                    product.getVariantImages().forEach(variantImage -> logger.info(variantImage.toString()));
                    product.getDiscountRefs().forEach(discountRef -> logger.info(discountRef.toString()));
                }
        );
    }
}
