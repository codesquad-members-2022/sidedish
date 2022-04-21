package sidedish.jbc.controller;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{type}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ResponseMenu> find(@PathVariable("type") String type) {
		return menuService.findMenu(MenuType.getInstance(type));
	}
}
