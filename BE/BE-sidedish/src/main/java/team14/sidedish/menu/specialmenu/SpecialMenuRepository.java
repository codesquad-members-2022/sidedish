package team14.sidedish.menu.specialmenu;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialMenuRepository extends CrudRepository<SpecialMenu, Long> {
	@Query("select a.SPECIAL_TITLE, a.MENU_ID, b.MENU_NAME, b.DESCRIPTION, b.MENU_PRICE from SIDEDISH_SPECIAL_MENUS a\n"
		+ "inner join SIDEDISH_MENUS b on a.MENU_ID = b.MENU_ID where a.EXHIBITIONS_ID = :exhibitionId;")
	List<SpecialMenus> findByExhibitionId(Long exhibitionId);
}
