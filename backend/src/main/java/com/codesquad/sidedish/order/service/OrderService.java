package com.codesquad.sidedish.order.service;

import com.codesquad.sidedish.item.domain.Category;
import com.codesquad.sidedish.item.domain.CategoryRepository;
import com.codesquad.sidedish.item.domain.Item;
import com.codesquad.sidedish.item.exception.CategoryIdNotFoundException;
import com.codesquad.sidedish.item.exception.ItemIdNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.codesquad.sidedish.order.domain.Order;
import com.codesquad.sidedish.order.domain.OrderRepository;
import com.codesquad.sidedish.order.dto.OrderItemDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;

    public OrderService(OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    public void order(OrderItemDto orderItemDto) {
        Order order = orderItemDto.toEntity();
        Integer itemId = order.getItemId();

        Category category = categoryRepository.findByItemId(itemId)
                .orElseThrow(() -> new CategoryIdNotFoundException("존재하지 않는 카테고리입니다."));

        Item orderedItem = category.getItems()
                .stream()
                .filter(item -> item.getId().equals(itemId))
                .findAny()
                .orElseThrow(() -> new ItemIdNotFoundException("존재하지 않는 아이템입니다."));

        orderedItem.removeStock(order.getAmount());

        categoryRepository.save(category);
        Order savedOrder = orderRepository.save(order);

        log.info("savedOrder : {}", savedOrder);
    }
}
