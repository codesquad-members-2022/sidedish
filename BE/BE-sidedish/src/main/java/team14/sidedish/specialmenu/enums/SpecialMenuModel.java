package team14.sidedish.specialmenu.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SpecialMenuModel {
	ONE("풍성한 고기 반찬", 1),
	TWO("편리한 반찬 세트", 2),
	THREE("맛있는 제철 요리", 3),
	FOUR("우리 아이 영양 반찬", 4);

	public static final String ERROR_OF_SPECIAL_MENU_MODEL_PARAM = "error of specialMenuModel param";
	private final String title;
	private final int id;

	public static SpecialMenuModel from(int id) {
		return Arrays.stream(values())
			.filter(it -> it.id == id)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_OF_SPECIAL_MENU_MODEL_PARAM));
	}
}
