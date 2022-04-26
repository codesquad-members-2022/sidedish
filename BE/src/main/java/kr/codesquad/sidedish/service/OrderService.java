package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Item;
import kr.codesquad.sidedish.domain.Order;
import kr.codesquad.sidedish.repository.ItemRepository;
import kr.codesquad.sidedish.repository.OrderRepository;
import kr.codesquad.sidedish.web.dto.order.OrderRequest;
import kr.codesquad.sidedish.web.dto.order.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public OrderResponse create(OrderRequest orderRequest) {
        Order saved = orderRepository.save(orderRequest.toEntity());
        Integer quantity = orderRequest.getQuantity();
        Long itemId = orderRequest.getItemId();
        Optional<Item> orderItem = itemRepository.findById(itemId);
        Item item = orderItem.orElseThrow();
        Integer stock = item.getStock();
        int newStock = stock - quantity;

        orderRepository.updateStock(newStock, itemId);
        return OrderResponse.from(saved);
    }
}
