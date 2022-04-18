package sidedish.jbc.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public List<ResponseMenu> menu() {
		return menuService.findAll();
	}

}
