package team14.sidedish.menu.specialmenu;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class SpecialMenus {
	private final String specialTitle;
	private final Long menuId;
	private final String menuName;
	private final String description;
	private final BigDecimal menuPrice;
}
