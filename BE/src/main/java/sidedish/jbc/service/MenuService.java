package sidedish.jbc.service;

import java.util.List;
import org.springframework.stereotype.Service;
import sidedish.jbc.domain.Menu;
import sidedish.jbc.domain.MenuType;
import sidedish.jbc.dto.DetailMenuImages;
import sidedish.jbc.dto.DetailMenuInfo;
import sidedish.jbc.dto.DetailMenuResponse;
import sidedish.jbc.dto.MenuResponse;
import sidedish.jbc.repository.ImageRepository;
import sidedish.jbc.repository.MenuRepository;

@Service
public class MenuService {

	private final MenuRepository menuRepository;
	private final ImageRepository imageRepository;

	public MenuService(MenuRepository menuRepository, ImageRepository imageRepository) {
		this.menuRepository = menuRepository;
		this.imageRepository = imageRepository;
	}

	public List<MenuResponse> findAll() {
		//todo Menu -> ResponseMenu로 변경하는 작업이 필요함
		Iterable<Menu> all = menuRepository.findAll();
		return null;
	}

	public List<MenuResponse> findMenu(String type) {
		return menuRepository.findAllByType(MenuType.getInstance(type));
	}

	public DetailMenuResponse findDetailMenu(int menuId) {
		DetailMenuInfo detailMenu = menuRepository.findDetailMenu(menuId);
		List<DetailMenuImages> imageInfo = imageRepository.findInfoByMenuId(menuId);
		return new DetailMenuResponse(detailMenu, imageInfo);
	}
}
