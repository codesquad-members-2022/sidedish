package com.team34.sidedish.repository;


import static org.assertj.core.api.Assertions.assertThat;

import com.team34.sidedish.domain.Category;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void findById() {
        Optional<Category> category = categoryRepository.findById(1L);
        assertThat(category).isNotEmpty()
            .get()
            .hasFieldOrPropertyWithValue("name", "든든한 메인요리");
    }
}
