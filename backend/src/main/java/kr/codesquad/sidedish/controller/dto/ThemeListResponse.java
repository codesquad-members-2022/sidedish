package kr.codesquad.sidedish.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ThemeListResponse {

    private final List<Element> specialCategories;

    @Getter
    @AllArgsConstructor
    public static class Element {

        private final Long id;
        private final String name;
    }
}
