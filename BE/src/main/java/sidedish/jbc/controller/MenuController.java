package sidedish.jbc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sidedish.jbc.domain.MenuType;
import sidedish.jbc.dto.DetailMenuResponse;
import sidedish.jbc.dto.MenuOrderResponse;
import sidedish.jbc.dto.MenuResponse;
import sidedish.jbc.dto.OrderRequest;
import sidedish.jbc.service.MenuService;
import sidedish.jbc.service.OrderService;

@Api(tags = "Sidedish project API")
@RestController
@RequestMapping("/menus")
public class MenuController {

	private final MenuService menuService;
	private final OrderService orderService;

	public MenuController(MenuService menuService, OrderService orderService) {
		this.menuService = menuService;
		this.orderService = orderService;
	}

	@ApiOperation(value = "특정 메뉴 타입 요청", notes = "지정된 타입의 메뉴들을 불러옵니다")
	@GetMapping
	public List<MenuResponse> findMenu(
		@ApiParam(name = "type", value = "요청할 메뉴 타입(예: soup)", required = true) @RequestParam("type") MenuType type) {
		return menuService.findMenu(type);
	}

	@ApiOperation(value = "상세 요청", notes = "지정된 id의 메뉴 상세정보를 불러옵니다.")
	@GetMapping("/detail/{id}")
	public DetailMenuResponse findDetailMenu(
		@ApiParam(name = "id", value = "상세 정보를 요청할 menu_id", required = true) @PathVariable("id") int menuId) {
		return menuService.findDetailMenu(menuId);
	}

	@ApiOperation(value = "메뉴 주문", notes = "지정된 id의 메뉴를 주문합니다.")
	@PostMapping("/detail/{id}")
	public MenuOrderResponse makeOrder(
		@RequestBody @ApiParam(name = "id", value = "상세 정보를 요청할 menu_id", required = true) OrderRequest orderRequest,
		@PathVariable("id") int menuId) {

		return orderService.save(orderRequest, menuId);
	}

}
