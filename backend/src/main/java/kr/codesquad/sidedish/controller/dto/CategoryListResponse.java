package kr.codesquad.sidedish.controller.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryListResponse {

    private List<Element> categories;

    @Getter
    @AllArgsConstructor
    public static class Element {

        Long id;
        String name;
        String description;

        List<SubElement> subcategories;
    }

    @Getter
    @AllArgsConstructor
    public static class SubElement {

        Long id;
        String name;
    }

}
