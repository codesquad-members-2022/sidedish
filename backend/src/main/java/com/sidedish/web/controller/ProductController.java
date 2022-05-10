package com.sidedish.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sidedish.servcie.ProductService;
import com.sidedish.web.dto.CategoryProductDto;
import com.sidedish.web.dto.OrderDto;
import com.sidedish.web.dto.ProductDetailDto;

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
        return productService.findById(id);
    }

    @PostMapping("order")
    public OrderDto order(@RequestBody OrderDto orderDto)  {
        if(orderDto.getQuantity() < 0) throw new IllegalStateException("잘못된 주문입니다.");
        productService.saveOrder(orderDto);
        return orderDto;
    }
}
