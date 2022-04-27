package com.sidedish.web.controller;

import com.sidedish.servcie.ProductService;
import com.sidedish.web.dto.EventCategoryProductDto;
import com.sidedish.web.dto.MainCategoryProductDto;
import com.sidedish.web.dto.ProductDetailDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

   @GetMapping("main")
    public List<MainCategoryProductDto> mainCategoryList(@RequestParam("category") String mainCategory){
        return productService.findMainCategory(mainCategory);
    }

    @GetMapping("event")
    public List<EventCategoryProductDto> categoryList(@RequestParam("category") String eventCategory){
        return productService.findEventCategory(eventCategory);
    }

    @GetMapping("{id}")
    public ProductDetailDto productDetail(@PathVariable("id") Long id){
        return productService.findById(id);
    }
}
