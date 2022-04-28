package team14.sidedish.specialmenu;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecialMenuRepository extends CrudRepository<SpecialMenu, Long> {
	@Query("select a.SPECIAL_TITLE, a.MENU_ID, b.MENU_NAME, b.DESCRIPTION, b.MENU_PRICE, c.MENU_IMAGE_URL from SIDEDISH_SPECIAL_MENUS a\n"
		+ "inner join SIDEDISH_MENUS b on a.MENU_ID = b.MENU_ID\n"
		+ "inner join SIDEDISH_IMAGE c on a.MENU_ID = c.IMAGE_MENU_ID\n"
		+ "where a.EXHIBITIONS_ID = :exhibitionId and a.SPECIAL_TITLE = :specialTitle and c.IMAGE_DEFAULT = 1;")
	List<SpecialMenuInfo> findByExhibitionIdAndSpecialTitle(@Param("exhibitionId") Long exhibitionId, @Param("specialTitle") String specialTitle);
}
