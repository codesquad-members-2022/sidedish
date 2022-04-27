package sidedish.jbc.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuType;
import sidedish.jbc.dto.DetailMenuResponse;
import sidedish.jbc.dto.MenuResponse;
import sidedish.jbc.repository.MenuRepository;

@Service
public class MenuService {

	private final MenuRepository menuRepository;

	public MenuService(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	public List<MenuResponse> findMenu(MenuType type) {
		return menuRepository.findAllByType(type);
	}

	public DetailMenuResponse findDetailMenu(int menuId) {
		Optional<Menu> menu = menuRepository.findAllById(menuId);
		return new DetailMenuResponse(menu.orElseThrow());
	}
}
