package sidedish.jbc.service;

import org.springframework.stereotype.Service;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuOrder;
import sidedish.jbc.dto.MenuOrderResponse;
import sidedish.jbc.dto.OrderRequest;
import sidedish.jbc.repository.MenuRepository;
import sidedish.jbc.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final MenuRepository menuRepository;

	public OrderService(OrderRepository orderRepository,
		MenuRepository menuRepository) {
		this.orderRepository = orderRepository;
		this.menuRepository = menuRepository;
	}

	public MenuOrderResponse save(OrderRequest request, int menuId) {
		Menu menu = menuRepository.findAllById(menuId).orElseThrow();
		MenuOrder menuOrder = new MenuOrder(menu, request);

		return new MenuOrderResponse(orderRepository.save(menuOrder), menu);
		// TODO: 메뉴 레포에 수량 업데이트하기
	}
}
