package com.sidedish.web.controller;

import com.sidedish.servcie.ProductService;
import com.sidedish.web.dto.CategoryProductDto;
import com.sidedish.web.dto.OrderDto;
import com.sidedish.web.dto.ProductDetailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("main")
    public List<CategoryProductDto> mainCategoryList(@RequestParam("category") String mainCategory) {
        return productService.findMainCategory(mainCategory);
    }

    @GetMapping("event")
    public List<CategoryProductDto> categoryList(@RequestParam("category") String eventCategory) {
        return productService.findEventCategory(eventCategory);
    }

    @GetMapping("{id}")
    public ProductDetailDto productDetail(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

    @PostMapping("order")
    public void order(@RequestBody OrderDto orderDto)  {
        if(orderDto.getQuantity() < 0) throw new IllegalStateException("잘못된 주문입니다.");
        productService.save(orderDto);
    }
}
