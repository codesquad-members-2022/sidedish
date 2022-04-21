package com.codesquad.sidedish.item.domain;

import org.junit.jupiter.api.BeforeEach;
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
class ItemRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(ItemRepositoryTest.class);

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        itemRepository.save(new Item(null, "name1", "des1", 100, 100, "link", 1, 1));
        itemRepository.save(new Item(null, "name1", "des1", 100, 100, "link", 1, 1));
    }

    @Test
    void findItem() {
        List<Item> all = itemRepository.findAll();
        all.stream().forEach(i -> log.debug("{}", i.toString()));
        assertThat(all.size()).isEqualTo(15);
    }

    @Test
    void findItemByCategory() {
        List<Item> all = itemRepository.findByCategoryId(1);
        assertThat(all.size()).isEqualTo(15);
    }

}
