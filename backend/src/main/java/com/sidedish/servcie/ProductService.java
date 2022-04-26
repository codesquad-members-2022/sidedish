package com.sidedish.servcie;

import com.sidedish.domain.product.Product;
import com.sidedish.repository.ProductRepository;
import com.sidedish.web.dto.MainCategoryProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<MainCategoryProductDto> findMainCategory(String mainCategory){
        List<Product> products = productRepository.findAllMainCategoryProduct(mainCategory);
        List<MainCategoryProductDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            dtoList.add(new MainCategoryProductDto(product.getProductName(), product.getDescription(), product.getPrice(), product.getEventBadge(),product.getMainCategory()));
        }
        return dtoList;
    }
}
