package team31.codesuqad.sidedish.controller.dto;

import java.util.ArrayList;
import java.util.List;
import team31.codesuqad.sidedish.domain.Category;

public class CategoryNames {

    private List<Category> categoryNames = new ArrayList<>();

    public CategoryNames(List<Category> categories) {
        for (Category category : categories) {
            categoryNames.add(category);
        }
    }

    public List<Category> getCategoryNames() {
        return categoryNames;
    }
}
