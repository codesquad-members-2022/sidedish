package com.codesquad.sidedish.item.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ItemRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(ItemRepositoryTest.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    private Integer size;
    private Integer id;
    private String testName;

    @BeforeEach
    void setUp() {
        List<Category> categoryList = categoryRepository.findAll();
        Set<Item> items = categoryList.get(0).getItems();
        size = items.size();
        testName = "testname";
        Item save = itemRepository.save(new Item(null, testName, "테스트 아이템", 5000, 10, "link", "테스트 할인", 20));
        id = save.getId();
    }

    @Test
    void findAll() {
        List<Category> all = categoryRepository.findAll();
        Category category = all.get(0);
        Set<Item> items = category.getItems();
        assertThat(items.size()).isEqualTo(size + 1);
    }

    @Test
    void findById() {
        Optional<Item> item = itemRepository.findById(id);
        assertThat(item).isPresent();
        Item item1 = item.get();
        assertThat(item1.getName()).isEqualTo(testName);
    }
}
