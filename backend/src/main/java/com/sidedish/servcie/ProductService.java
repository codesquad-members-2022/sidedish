package com.sidedish.servcie;

import com.sidedish.domain.product.Product;
import com.sidedish.repository.ProductRepository;
import com.sidedish.web.dto.EventCategoryProductDto;
import com.sidedish.web.dto.MainCategoryProductDto;
import com.sidedish.web.dto.ProductDetailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<MainCategoryProductDto> findMainCategory(String mainCategory){
        List<Product> products = productRepository.findAllMainCategoryProduct(mainCategory);
        List<MainCategoryProductDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            dtoList.add(new MainCategoryProductDto(product.getProductName(), product.getDescription(), product.getEarlyDelivery(), product.getPrice(), product.getEventBadge(),product.getMainCategory()));
        }
        return dtoList;
    }

    public List<EventCategoryProductDto> findEventCategory(String eventCategory) {
        List<Product> products = productRepository.findAllEventCategoryProduct(eventCategory);
        List<EventCategoryProductDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            dtoList.add(new EventCategoryProductDto(product.getProductName(), product.getDescription(), product.getEarlyDelivery(), product.getPrice(), product.getEventBadge(),product.getEventCategory()));
        }
        return dtoList;
    }

    public ProductDetailDto findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        log.debug("잘 나왔니? :{}", product);
        return new ProductDetailDto(product.getProductName(), product.getEarlyDelivery(), product.getPrice(), product.getEventBadge(), product.getImages());
    }


}
