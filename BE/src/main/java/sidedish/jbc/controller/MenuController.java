package sidedish.jbc.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sidedish.jbc.domain.MenuType;
import sidedish.jbc.dto.ResponseMenu;
import sidedish.jbc.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	private final MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ResponseMenu> menu() {
		return menuService.findAll();
	}

	@GetMapping("/main")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ResponseMenu> find() {
		return menuService.findMenu(MenuType.MAIN);
	}

	@GetMapping("/soup")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ResponseMenu> soup() {
		return menuService.findMenu(MenuType.SOUP);
	}

	@GetMapping("/side")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ResponseMenu> side() {
		return menuService.findMenu(MenuType.SIDE);
	}
}
