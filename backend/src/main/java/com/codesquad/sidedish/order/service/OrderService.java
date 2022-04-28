package com.codesquad.sidedish.order.service;

import com.codesquad.sidedish.item.domain.Item;
import com.codesquad.sidedish.item.domain.ItemRepository;
import com.codesquad.sidedish.item.exception.ItemIdNotFoundException;
import com.codesquad.sidedish.order.domain.Order;
import com.codesquad.sidedish.order.domain.OrderRepository;
import com.codesquad.sidedish.order.dto.OrderItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public void order(OrderItemDto orderItemDto) {
        Integer itemId = orderItemDto.getItemId();

        Item orderedItem = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemIdNotFoundException("존재하지 않는 아이템입니다.", HttpStatus.NOT_FOUND));

        orderedItem.removeStock(orderItemDto.getAmount());

        itemRepository.save(orderedItem);
        Order savedOrder = orderRepository.save(orderItemDto.toEntity());

        log.info("savedOrder : {}", savedOrder);
    }
}
