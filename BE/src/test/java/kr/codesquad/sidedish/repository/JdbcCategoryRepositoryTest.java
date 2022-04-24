package kr.codesquad.sidedish.repository;


import kr.codesquad.sidedish.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import static org.assertj.core.api.Assertions.*;

@DataJdbcTest
class JdbcCategoryRepositoryTest {

    @Autowired
    private JdbcCategoryRepository jdbcCategoryRepository;


    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category(null, "짱민", "짱");
    }
    @Test
    void test() {

        Category saved = jdbcCategoryRepository.save(category);
        assertThat(saved.getId()).isEqualTo(1L);
        assertThat(saved.getName()).isEqualTo("짱민");
        assertThat(saved.getDescription()).isEqualTo("짱");

    }

}
