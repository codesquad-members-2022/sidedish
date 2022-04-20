package sidedish.jbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuType;
import sidedish.jbc.dto.ResponseMenu;
import sidedish.jbc.repository.MenuRepository;

@Service
public class MenuService {

	private final MenuRepository menuRepository;

	public MenuService(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	public List<ResponseMenu> findAll() {
		//todo Menu -> ResponseMenu로 변경하는 작업이 필요함
		Iterable<Menu> all = menuRepository.findAll();
		return null;
	}

	public List<ResponseMenu> findMenu(MenuType menuType) {
		return menuRepository.findAllByType(menuType.getTypeValue());
	}
}
