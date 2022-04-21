package com.codesquad.sidedish.item.domain;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class CategoryRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(CategoryRepositoryTest.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void findAll() {
        List<Category> all = categoryRepository.findAll();
        Category category = all.get(1);
        String name = all.get(1).getName();
        category.getItems().forEach(i -> log.debug("{}", i.toString()));
        assertThat(category.getItems().size()).isEqualTo(3);
    }
}
