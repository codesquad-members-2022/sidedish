package sidedish.web.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sidedish.domain.category.MainCategory;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseMainCategoryDto {
    private List<MainCategory> mainCategories;
}
