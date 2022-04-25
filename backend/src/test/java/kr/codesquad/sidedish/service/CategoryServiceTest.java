package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Category;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    @Transactional
    @DisplayName("테스트 DB에서 카테고리 목록을 조회하면 3개의 카테고리가 조회되어야 한다.")
    void readAll_categoryCount() {
        List<Category> categories = categoryService.readAll();

        assertThat(categories).hasSize(3);
    }

    @Test
    @Transactional
    @DisplayName("테스트 DB에서 카테고리 목록을 조회하면 각각 2개, 1개, 3개의 서브카테고리가 조회되어야 한다.")
    void readAll_subCategoryCount() {
        List<Category> categories = categoryService.readAll();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(categories.get(0).getSubcategories().size()).isEqualTo(2);
        softly.assertThat(categories.get(1).getSubcategories().size()).isEqualTo(1);
        softly.assertThat(categories.get(2).getSubcategories().size()).isEqualTo(3);
        softly.assertAll();
    }
}
