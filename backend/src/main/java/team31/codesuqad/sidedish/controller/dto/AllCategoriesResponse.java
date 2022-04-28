package team31.codesuqad.sidedish.controller.dto;

import java.util.List;

public class AllCategoriesResponse {

    private List<CategoryResponse> categories;

    public AllCategoriesResponse(List<CategoryResponse> categories) {
        this.categories = categories;
    }

    public List<CategoryResponse> getCategories() {
        return categories;
    }
}
