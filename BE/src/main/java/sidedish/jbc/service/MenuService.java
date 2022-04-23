package sidedish.jbc.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuType;
import sidedish.jbc.domain.MenuOrder;
import sidedish.jbc.dto.DetailMenuImages;
import sidedish.jbc.dto.DetailMenuInfo;
import sidedish.jbc.dto.DetailMenuResponse;
import sidedish.jbc.dto.MenuResponse;
import sidedish.jbc.dto.OrderRequest;
import sidedish.jbc.repository.ImageRepository;
import sidedish.jbc.repository.MenuRepository;
import sidedish.jbc.repository.OrderRepository;

@Service
public class MenuService {

	private final MenuRepository menuRepository;
	private final ImageRepository imageRepository;

	public MenuService(MenuRepository menuRepository,
		ImageRepository imageRepository) {
		this.menuRepository = menuRepository;
		this.imageRepository = imageRepository;
	}

	public List<MenuResponse> findAll() {
		Iterable<Menu> all = menuRepository.findAll();
		return null;
	}

	public List<MenuResponse> findMenu(MenuType type) {
		return menuRepository.findAllByType(type);
	}

	public DetailMenuResponse findDetailMenu(int menuId) {
		DetailMenuInfo detailMenu = menuRepository.findDetailMenu(menuId);
		List<DetailMenuImages> imageInfo = imageRepository.findInfoByMenuId(menuId);
		return new DetailMenuResponse(detailMenu, imageInfo);
	}
}
