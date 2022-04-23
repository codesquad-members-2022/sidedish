package team14.sidedish.menu;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import team14.sidedish.exhibition.ExhibitionDto;
import team14.sidedish.exhibition.ExhibitionService;
import team14.sidedish.menu.specialmenu.SpecialMenuService;
import team14.sidedish.menu.specialmenu.SpecialMenus;

@RequiredArgsConstructor
@Service
public class MenuService {
	private final ExhibitionService exhibitionService;
	private final SpecialMenuService specialMenuService;

	private final MenuRepository menuRepository;

	public void readExhibition() {
		ExhibitionDto exhibitionInfo = exhibitionService.readOngoing();
		List<SpecialMenus> specialMenusInfo = specialMenuService.read(exhibitionInfo.getExhibitionId());
	}
}
