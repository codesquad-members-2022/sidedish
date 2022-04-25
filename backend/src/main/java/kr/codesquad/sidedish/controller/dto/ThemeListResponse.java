package kr.codesquad.sidedish.controller.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ThemeListResponse {

	private final List<Element> themes;

	@Getter
	@AllArgsConstructor
	public static class Element {

		Long id;
		String name;
	}
}
