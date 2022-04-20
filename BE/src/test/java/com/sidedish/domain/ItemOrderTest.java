package com.sidedish.domain;


import com.sidedish.repository.ItemRepository;
import com.sidedish.repository.OrderRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("local")
class ItemOrderTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void test() {
    //given
    Order order = new Order(BigDecimal.valueOf(5000), "서울특별시");
    orderRepository.save(order);

    Item newItem = new Item("고기", "맛있는 고기", BigDecimal.valueOf(10000),
        10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html");
    newItem.addOrders(order);
    itemRepository.save(newItem);


    //when
    for (Item i : itemRepository.findAll()) {
        System.out.println("주문: " + orderRepository.findAllById(i.getOderIds()));
    }

    for (Order o : orderRepository.findAll()) {
        System.out.println("아이템: " + itemRepository.findByOrderId(o.getId()));
    }
    //then

    }
}
