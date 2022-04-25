package sidedish.jbc.service;

import org.springframework.stereotype.Service;
import sidedish.jbc.dto.MenuOrderResponse;
import sidedish.jbc.dto.OrderRequest;
import sidedish.jbc.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public MenuOrderResponse save(OrderRequest request) {
		return new MenuOrderResponse(orderRepository.save(request.toEntity()));
	}
}
