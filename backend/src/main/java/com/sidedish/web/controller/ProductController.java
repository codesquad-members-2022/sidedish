package com.sidedish.web.controller;

import com.sidedish.servcie.ProductService;
import com.sidedish.web.dto.CategoryProductDto;
import com.sidedish.web.dto.EventCategoryProductDto;
import com.sidedish.web.dto.MainCategoryProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

/*    @GetMapping
    public List<MainCategoryProductDto> mainCategoryList(@RequestParam("main-category") String mainCategory){
        return productService.findMainCategory(mainCategory);
    }

    @GetMapping
    public List<EventCategoryProductDto> eventCategoryProductDtoList(@RequestParam("event-category") String eventCategory){
        return productService.findEventCategory(eventCategory);
    }*/

    @GetMapping
    public List<CategoryProductDto> mainCategoryList(@RequestParam("category-type") String categoryType){
        return productService.findCategory(categoryType);
    }
}
