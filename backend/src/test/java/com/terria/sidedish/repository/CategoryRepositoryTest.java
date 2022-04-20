package com.terria.sidedish.repository;

import com.terria.sidedish.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void findAll() {
        List<Category> categories = categoryRepository.findAll();
        assertThat(categories).isNotNull();
    }
}