package com.sidedish.web.controller;

import com.sidedish.domain.product.Product;
import com.sidedish.servcie.ProductService;
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
    public List<Product> mainCategoryList(@RequestParam("category") String mainCategory) {
        return productService.findMainCategory(mainCategory);
    }

    @GetMapping("event")
    public List<Product> categoryList(@RequestParam("category") String eventCategory) {
        return productService.findEventCategory(eventCategory);
    }

    @GetMapping("{id}")
    public Product productDetail(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

/*    @PostMapping("order")
    public OrderDto order(@RequestBody OrderDto orderDto)  {
        if(orderDto.getQuantity() < 0) throw new IllegalStateException("잘못된 주문입니다.");
        productService.saveOrder(orderDto);
        return orderDto;
    }*/
}
