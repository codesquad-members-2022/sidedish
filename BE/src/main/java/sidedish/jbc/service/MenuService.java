package sidedish.jbc.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sidedish.jbc.dto.ResponseMenu;
import sidedish.jbc.repository.MenuRepository;

@Service
public class MenuService {

	private final MenuRepository menuRepository;

	public MenuService(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	public List<ResponseMenu> findAll() {
		return menuRepository.findAll();
	}
}
