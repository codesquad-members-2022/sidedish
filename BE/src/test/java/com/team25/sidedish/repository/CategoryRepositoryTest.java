package com.team25.sidedish.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.team25.sidedish.domain.Category;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class CategoryRepositoryTest {
    private static final int CATEGORY_COUNT = 3;
    private static final String CATEGORY_1_NAME = "모두가 좋아하는 든든한 메인요리";
    private static final int CATEGORY_1_PRODUCT_COUNT = 3;
    private static final String CATEGORY_2_NAME = "정성이 담긴 뜨끈한 국물요리";
    private static final int CATEGORY_2_PRODUCT_COUNT = 2;
    private static final String CATEGORY_3_NAME = "식탁을 풍성하게 하는 정갈한 밑반찬";
    private static final int CATEGORY_3_PRODUCT_COUNT = 1;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @DisplayName("카테고리 목록을 조회할 수 있다")
    void 카테고리_목록_조회_테스트() {
        // when
        List<Category> results = Lists.newArrayList(categoryRepository.findAll());

        // then
        assertThat(results).hasSize(CATEGORY_COUNT);

        assertThat(results.get(0).getName()).isEqualTo(CATEGORY_1_NAME);
        assertThat(results.get(0).getProductCount()).isEqualTo(CATEGORY_1_PRODUCT_COUNT);

        assertThat(results.get(1).getName()).isEqualTo(CATEGORY_2_NAME);
        assertThat(results.get(1).getProductCount()).isEqualTo(CATEGORY_2_PRODUCT_COUNT);

        assertThat(results.get(2).getName()).isEqualTo(CATEGORY_3_NAME);
        assertThat(results.get(2).getProductCount()).isEqualTo(CATEGORY_3_PRODUCT_COUNT);
    }
}
