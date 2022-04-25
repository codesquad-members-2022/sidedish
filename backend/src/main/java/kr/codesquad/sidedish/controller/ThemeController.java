package kr.codesquad.sidedish.controller;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.sidedish.controller.dto.ThemeListResponse;
import kr.codesquad.sidedish.domain.Theme;
import kr.codesquad.sidedish.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/themes")
@RequiredArgsConstructor
public class ThemeController {

	private final ThemeService themeService;

	@GetMapping
	public ThemeListResponse themeListResponse(){
		List<ThemeListResponse.Element> elements = themeService.readAll()
			.stream()
			.map(this::entityToDTO)
			.collect(Collectors.toList());

		return new ThemeListResponse(elements);
	}


	private ThemeListResponse.Element entityToDTO(Theme theme) {
		return new ThemeListResponse.Element(theme.getId(), theme.getName());
	}
}
