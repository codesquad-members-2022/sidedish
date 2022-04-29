package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.controller.dto.ThemeListResponse;
import kr.codesquad.sidedish.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/specialCategories")
@RequiredArgsConstructor
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping
    public ThemeListResponse themeListResponse(){
        return new ThemeListResponse(themeService.readAll());
    }
}
