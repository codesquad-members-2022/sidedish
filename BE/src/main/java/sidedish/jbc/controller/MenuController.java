package sidedish.jbc.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sidedish.jbc.dto.DetailMenuResponse;
import sidedish.jbc.dto.MenuResponse;
import sidedish.jbc.dto.OrderRequest;
import sidedish.jbc.service.MenuService;
import sidedish.jbc.service.OrderService;

@Controller
@RequestMapping("/menus")
public class MenuController {

	private final MenuService menuService;
	private final OrderService orderService;

	public MenuController(MenuService menuService, OrderService orderService) {
		this.menuService = menuService;
		this.orderService = orderService;
	}

	@GetMapping
	@ResponseBody
	public List<MenuResponse> welcome() {
		return menuService.findAll();
	}

	@GetMapping("/{type}")
	@ResponseBody
	public List<MenuResponse> findMenu(@PathVariable("type") String type) {
		return menuService.findMenu(type);
	}

	@GetMapping("/detail/{id}")
	@ResponseBody
	public DetailMenuResponse findDetailMenu(@PathVariable("id") int menuId) {
		return menuService.findDetailMenu(menuId);
	}

	@PostMapping("/detail/{id}")
	public String makeOrder(@RequestBody OrderRequest orderRequest) {
		orderService.save(orderRequest);
		return "redirect:/menus/detail/{id}";
	}

}
