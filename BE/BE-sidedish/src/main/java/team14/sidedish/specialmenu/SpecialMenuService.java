package team14.sidedish.specialmenu;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import team14.sidedish.menu.MenuDto;

@RequiredArgsConstructor
@Service
public class SpecialMenuService {
	private final SpecialMenuRepository specialMenuRepository;

	/**
	 * 진행중인 기획전과 요청받은 추천메뉴 제목에 해당하는 메뉴 목록을 반환 합니다.
	 *  - 메뉴에 해당하는 기본 이미지만 추가합니다.
	 *  - MenuDto.SubCategory : menu 에 대해 일괄적으로 view 로 전달
	 * @param exhibitionId, title
	 * @return
	 */
	public List<MenuDto.SubCategory> read(Long exhibitionId, String title) {
		List<SpecialMenuInfo> specialMenus = specialMenuRepository.findByExhibitionIdAndSpecialTitle(exhibitionId, title);
		return specialMenus.stream()
			.map(specialMenu -> {
				return MenuDto.SubCategory.builder()
					.menuId(specialMenu.getMenuId())
					.menuName(specialMenu.getMenuName())
					.description(specialMenu.getDescription())
					.image(List.of(specialMenu.getImageUrl()))
					.originalPrice(specialMenu.getPrice())
					.build();
				}).collect(Collectors.toList());
	}
}
