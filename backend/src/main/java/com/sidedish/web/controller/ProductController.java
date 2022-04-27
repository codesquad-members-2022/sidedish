package com.sidedish.web.controller;

import com.sidedish.servcie.ProductService;
import com.sidedish.web.dto.EventCategoryProductDto;
import com.sidedish.web.dto.MainCategoryProductDto;
import com.sidedish.web.dto.ProductDetailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

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
        log.debug("컨크롤러 들어왔니?----------------");
        return productService.findById(id);
    }
}
