package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Item;
import kr.codesquad.sidedish.domain.Order;
import kr.codesquad.sidedish.repository.ItemRepository;
import kr.codesquad.sidedish.repository.OrderRepository;
import kr.codesquad.sidedish.web.dto.order.OrderRequest;
import kr.codesquad.sidedish.web.dto.order.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public OrderResponse create(OrderRequest orderRequest) {
        Integer quantity = orderRequest.getQuantity();
        Long itemId = orderRequest.getItemId();
        Item item = itemRepository.findById(itemId).orElseThrow(RuntimeException::new);
        if (item.checkStock(quantity)) {
          throw new IllegalStateException("재고 수량이 부족합니다");
        }
        Order saved = orderRepository.save(orderRequest.toEntity());
        item.changeStock(quantity);
        orderRepository.updateStock(item.getStock(), itemId);
        return OrderResponse.from(saved);
    }
}
