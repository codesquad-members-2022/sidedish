package kr.codesquad.sidedish.controller;

import kr.codesquad.sidedish.controller.dto.ProductListRequest;
import kr.codesquad.sidedish.controller.dto.ProductListResponse;
import kr.codesquad.sidedish.controller.dto.ProductResponse;
import kr.codesquad.sidedish.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ProductListResponse listProducts(ProductListRequest productListRequest) {
        List<ProductResponse> productResponses = productService.readAllBy(
                productListRequest.getCategoryId(),
                productListRequest.getThemeId(),
                productListRequest.getSortRule(),
                productListRequest.getOffset(),
                productListRequest.getPageSize());

        return new ProductListResponse(productListRequest, productResponses);
    }
}
