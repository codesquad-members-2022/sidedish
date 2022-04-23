package team14.sidedish.menu.specialmenu;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SpecialMenuService {
	private final SpecialMenuRepository specialMenuRepository;

	public List<SpecialMenus> read(Long exhibitionId) {
		return specialMenuRepository.findByExhibitionId(exhibitionId);
	}
}
