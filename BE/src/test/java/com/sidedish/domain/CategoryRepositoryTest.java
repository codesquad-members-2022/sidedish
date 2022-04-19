package com.sidedish.domain;

import com.sidedish.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void createCategoryRepository() {
        // given
        Category mainCategory = new Category(CategoryType.MAIN);

        // when
        categoryRepository.save(mainCategory);

        // then
        assertThat(mainCategory.getId()).isNotNull();
    }
}
