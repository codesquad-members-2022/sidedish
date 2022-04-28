package team14.sidedish.specialmenu;

import org.springframework.data.relational.core.mapping.Table;

@Table("SIDEDISH_SPECIAL_MENUS")
public class SpecialMenu {
	private final String specialTitle;
	private final Long menuId;
	private final Long exhibitionsId;

	protected SpecialMenu(String specialTitle, Long menuId, Long exhibitionsId) {
		this.specialTitle = specialTitle;
		this.menuId = menuId;
		this.exhibitionsId = exhibitionsId;
	}
}
