package kr.codesquad.sidedish.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CategoryListResponse {

    private List<Element> categories;

    @Getter
    @AllArgsConstructor
    public static class Element {

        private final Long id;
        private final String name;
        private final String description;

        private final List<SubElement> subcategories;
    }

    @Getter
    @AllArgsConstructor
    public static class SubElement {

        private final Long id;
        private final String name;
    }

}
