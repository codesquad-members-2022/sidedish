package sidedish.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sidedish.domain.category.MainCategory;
import sidedish.service.CategoryService;
import sidedish.web.dto.ResponseDto;
import sidedish.web.dto.item.ResponseItemsDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseDto<List<MainCategory>> getCategories() {
        List<MainCategory> categories = categoryService.findCategories();
        return new ResponseDto<>(HttpStatus.OK, categories);
    }

    @GetMapping("/{categoryId}/items")
    public ResponseDto<ResponseItemsDto> getCategoryItems(@PathVariable Long categoryId) {
        return new ResponseDto<>(HttpStatus.OK, categoryService.findCategoryItems(categoryId));
    }

}
