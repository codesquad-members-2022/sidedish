package team14.sidedish.specialmenu;

import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class SpecialMenuInfo {
	private final String specialTitle;
	private final Long menuId;
	private final String menuName;
	private final String description;
	private final BigDecimal menuPrice;
	@Column("MENU_IMAGE_URL")
	private final String imageUrl;

	public Long getMenuId() {
		return menuId;
	}

	public BigDecimal getPrice() {
		return this.menuPrice;
	}
}
