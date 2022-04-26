package com.sidedish.servcie;

import com.sidedish.domain.product.MainCategory;
import com.sidedish.domain.product.Product;
import com.sidedish.repository.ProductRepository;
import com.sidedish.web.dto.CategoryProductDto;
import com.sidedish.web.dto.EventCategoryProductDto;
import com.sidedish.web.dto.MainCategoryProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<EventCategoryProductDto> findEventCategory(String eventCategory) {
        List<Product> products = productRepository.findAllEventCategoryProduct(eventCategory);
        List<EventCategoryProductDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            dtoList.add(new EventCategoryProductDto(product.getProductName(), product.getDescription(), product.getPrice(), product.getEventBadge(),product.getEventCategory()));
        }
        return dtoList;
    }

    public List<CategoryProductDto> findCategory(String categoryType) {
        if (Arrays.stream(MainCategory.values()).anyMatch(value -> value.equals(categoryType))) {
            List<Product> products = productRepository.findAllMainCategoryProduct(categoryType);
            List<CategoryProductDto> dtoList = new ArrayList<>();
            for (Product product : products) {
                dtoList.add(new MainCategoryProductDto(product.getProductName(), product.getDescription(), product.getPrice(), product.getEventBadge(),product.getMainCategory()));
            }
            return dtoList;
        }
        List<Product> products = productRepository.findAllEventCategoryProduct(categoryType);
        List<CategoryProductDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            dtoList.add(new EventCategoryProductDto(product.getProductName(), product.getDescription(), product.getPrice(), product.getEventBadge(),product.getEventCategory()));
        }
        return dtoList;
    }
}
