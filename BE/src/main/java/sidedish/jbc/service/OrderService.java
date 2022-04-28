package sidedish.jbc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuOrder;
import sidedish.jbc.dto.MenuOrderResponse;
import sidedish.jbc.dto.OrderRequest;
import sidedish.jbc.repository.MenuRepository;
import sidedish.jbc.repository.OrderRepository;
import sidedish.jbc.repository.UserRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final MenuRepository menuRepository;
	private final UserRepository userRepository;

	public OrderService(OrderRepository orderRepository,
		MenuRepository menuRepository, UserRepository userRepository) {
		this.orderRepository = orderRepository;
		this.menuRepository = menuRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	public MenuOrderResponse save(OrderRequest request, int menuId) {
		Menu menu = menuRepository.findAllById(menuId).orElseThrow();
		MenuOrder menuOrder = new MenuOrder(menu, request);

		int remainStock = menu.getStock() - menuOrder.getQuantity();

		if (remainStock < 0) {
			throw new IllegalStateException("재고가 부족합니다.");
		}
		MenuOrderResponse menuOrderResponse = new MenuOrderResponse(orderRepository.save(menuOrder),
			menu);
		menuRepository.updateStock(remainStock, menuId);
		userRepository.updatePoint(request.getUserId(),
			menu.getSaleType().calculatePoint(menu.getPrice(), menuOrder));

		return menuOrderResponse;
	}


}
