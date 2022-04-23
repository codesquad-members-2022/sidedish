package com.sidedish.domain;

import com.sidedish.repository.CategoryRepository;
import com.sidedish.repository.ItemRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
class ItemTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @Transactional
    @DisplayName("정상적으로 아이템이 저장이 되면, 저장된 아이템의 타이틀이 반환되어야 한다.")
    void itemSaveTest() {
        // given
        Category mainCategory = new Category(CategoryType.MAIN);
        Item newItem = new Item("고기", "맛있는 고기", BigDecimal.valueOf(10000),
                10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), new Images("mainUrl", "one", "two"));

        // when
        mainCategory.saveItem(newItem);
        Category savedCategory = categoryRepository.save(mainCategory);

        // then
        Category findCategory = categoryRepository.findById(savedCategory.getId()).get();
        List<Item> findItems = findCategory.getItems();
        Item findItem = findItems.get(0);
        assertThat(findItem.getTitle()).isEqualTo("고기");
    }
}
