package sidedish.jbc.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sidedish.jbc.dto.DetailMenuResponse;
import sidedish.jbc.dto.MenuResponse;
import sidedish.jbc.service.MenuService;

@Controller
@RequestMapping("/menus")
public class MenuController {

	private final MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<MenuResponse> welcome() {
		return menuService.findAll();
	}

	@GetMapping("/{type}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<MenuResponse> findMenu(@PathVariable("type") String type) {
		return menuService.findMenu(type);
	}

	@GetMapping("/detail/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public DetailMenuResponse findDetailMenu(@PathVariable("id") int menuId) {
		return menuService.findDetailMenu(menuId);
	}
}
