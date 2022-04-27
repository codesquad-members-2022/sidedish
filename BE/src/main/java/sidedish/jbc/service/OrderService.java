package sidedish.jbc.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuOrder;
import sidedish.jbc.domain.User;
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

	public MenuOrderResponse save(OrderRequest request, int menuId) {
		Menu menu = menuRepository.findAllById(menuId).orElseThrow();
		MenuOrder menuOrder = new MenuOrder(menu, request);

		int remainStock = menu.getStock() - menuOrder.getQuantity();

		if (remainStock < 0) {
			throw new IllegalStateException("재고가 부족합니다.");
		}
		MenuOrderResponse menuOrderResponse = new MenuOrderResponse(orderRepository.save(menuOrder), menu);
		menuRepository.updateStock(menuId, remainStock);
		userRepository.updatePoint(request.getUserId(), getPoint(menu, menuOrder));
		Optional<User> user = userRepository.findById(request.getUserId());
		System.out.println(user.get());

		return menuOrderResponse;
	}

	private int getPoint(Menu menu, MenuOrder menuOrder) {
		return (int) ((menu.getPrice() * ((100 - menu.getSaleType().getSalePercentage()) / 100f))
			* 0.01 * menuOrder.getQuantity());
	}
}
