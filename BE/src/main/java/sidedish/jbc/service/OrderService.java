package sidedish.jbc.service;

import org.springframework.stereotype.Service;
import sidedish.jbc.domain.MenuOrder;
import sidedish.jbc.dto.OrderRequest;
import sidedish.jbc.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public MenuOrder save(OrderRequest request) {
		return orderRepository.save(request.toEntity());
	}
}
