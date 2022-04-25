package sidedish.jbc.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuType;
import sidedish.jbc.dto.DetailMenu;
import sidedish.jbc.dto.DetailMenuImages;
import sidedish.jbc.dto.DetailMenuResponse;
import sidedish.jbc.dto.MenuResponse;
import sidedish.jbc.repository.ImageRepository;
import sidedish.jbc.repository.MenuRepository;

@Service
public class MenuService {

	private final MenuRepository menuRepository;
	private final ImageRepository imageRepository;

	public MenuService(MenuRepository menuRepository,
		ImageRepository imageRepository) {
		this.menuRepository = menuRepository;
		this.imageRepository = imageRepository;
	}

	public List<MenuResponse> findMenu(MenuType type) {
		return menuRepository.findAllByType(type);
	}

	public DetailMenuResponse findDetailMenu(int menuId) {
		DetailMenu detailMenu = menuRepository.findDetailMenu(menuId).orElseThrow();
		List<DetailMenuImages> imageInfo = imageRepository.findByMenuId(menuId);

		Optional<Menu> menu = menuRepository.findMenu(menuId);
		System.out.println(menu.get());

		return new DetailMenuResponse(detailMenu, imageInfo);
	}
}
