package com.sidedish.domain;


import static org.assertj.core.api.Assertions.assertThat;

import com.sidedish.repository.ItemRepository;
import com.sidedish.repository.OrderRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Set;

@SpringBootTest
@ActiveProfiles("local")
class ItemOrderTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @DisplayName("주문에 아이템이 정상적으로 추가되면 True를 반환해야한다.")
    void itemOrderTest() {
        //given
        Order order = new Order(BigDecimal.valueOf(5000), "서울특별시");
        orderRepository.save(order);

        Item newItem = new Item("고기", "맛있는 고기", BigDecimal.valueOf(10000),
                10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html", CategoryType.MAIN);

        //when
        newItem.addOrders(order);
        itemRepository.save(newItem);

        //then
        Order findOrder = orderRepository.findById(order.getId()).get();
        Set<Item> findItems = itemRepository.findByOrderId(findOrder.getId());

        assertThat(findItems.stream().anyMatch(i -> i.equals(newItem))).isTrue();
    }
}
