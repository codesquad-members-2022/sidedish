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
class ItemTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void itemSaveTest() {
        // given
        Category mainCategory = new Category(CategoryType.MAIN);

        Item newItem = new Item("고기", "맛있는 고기", BigDecimal.valueOf(10000),
                10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html");
//        Item newItem = Item.builder()
//                .title("고기")
//                .description("맛있는 고기")
//                .price(BigDecimal.valueOf(10000))
//                .discountRate(10.0)
//                .badge(Badge.EVENT)
//                .detailType("풍성한 고기 반찬")
//                .quantity(10)
//                .image("url")
//                .rewardPoint(BigDecimal.valueOf(100))
//                .build();

        // when
        mainCategory.saveItem(newItem); // item의 id가 null
        Category savedCategory = categoryRepository.save(mainCategory); // category는 id생성, but item의 아이디는??

        // then
        Category findCategory = categoryRepository.findById(savedCategory.getId()).get();
        List<Item> findItems = findCategory.getItems();
        Item findItem = findItems.get(0);
        assertThat(findItem.getTitle()).isEqualTo("고기");

//        Category category = categoryRepository.findById(savedCategory.getId()).get();
//        final Item item = items.get(0);
//        System.out.println(item.getId());
//        Order order = Order.of(1, item.getId());
//        user.addOrder(order);
//        userRepository.save(user);
//
//        assertThat(userRepository.findById(1L).get().getOrders().get(0).getItemId()).isEqualTo(item.getId());
    }
}
