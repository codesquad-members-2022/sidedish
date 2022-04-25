package team14.sidedish.specialmenu.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class SpecialMenuValue {
	private int id;
	private String title;

	public SpecialMenuValue(SpecialMenuModel specialMenuModel) {
		this.id = specialMenuModel.getId();
		this.title = specialMenuModel.getTitle();
	}

	public static List<SpecialMenuValue> getSpecialMenuTitles() {
		return Arrays.stream(SpecialMenuModel.values())
			.map(SpecialMenuValue::new)
			.collect(Collectors.toList());
	}
}
