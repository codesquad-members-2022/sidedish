package com.sidedish.servcie;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sidedish.domain.Image;
import com.sidedish.domain.product.EventBadge;
import com.sidedish.domain.product.Product;
import com.sidedish.domain.product.ProductOrder;
import com.sidedish.repository.OrderRepository;
import com.sidedish.repository.ProductRepository;
import com.sidedish.web.dto.CategoryProductDto;
import com.sidedish.web.dto.ImageDto;
import com.sidedish.web.dto.OrderDto;
import com.sidedish.web.dto.ProductDetailDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public List<CategoryProductDto> findMainCategory(String mainCategory){
        List<Product> products = productRepository.findAllMainCategoryProduct(mainCategory);
        List<CategoryProductDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            String thumbnail = product.getImage().stream().findFirst().get().getImagePath();
            dtoList.add(new CategoryProductDto(product.getId(), product.getProductName(), product.getDescription(), product.getEarlyDelivery(), product.getPrice(), product.getEventBadge(), product.getEventBadge().getDiscountRate(), thumbnail));
        }
        return dtoList;
    }

    public List<CategoryProductDto> findEventCategory(String eventCategory) {
        List<Product> products = productRepository.findAllEventCategoryProduct(eventCategory);
        List<CategoryProductDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            String thumbnail = product.getImage().stream().findFirst().get().getImagePath();
            dtoList.add(new CategoryProductDto(product.getId(), product.getProductName(), product.getDescription(), product.getEarlyDelivery(), product.getPrice(), product.getEventBadge(), product.getEventBadge().getDiscountRate(), thumbnail));
        }
        return dtoList;
    }

    public ProductDetailDto findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        Set<ImageDto> imageSet = new LinkedHashSet<>();
        for (Image image : product.getImage()) {
            imageSet.add(new ImageDto(image.getId(), image.getImagePath()));
        }
        return new ProductDetailDto(product.getProductName(), product.getEarlyDelivery(), product.getPrice(), product.getEventBadge(), product.getEventBadge().getDiscountRate(),imageSet);
    }

    public void saveOrder(OrderDto dto) {
        if (!isLessThanStock(dto.getProductId(), dto.getQuantity())) throw new IllegalStateException("재고가 부족합니다");
        if (!isValidPrice(dto.getProductId(), dto.getPrice(), dto.getQuantity())) throw new IllegalStateException("금액이 올바르지 않습니다.");
        productRepository.abstractStock(dto.getProductId(), dto.getQuantity());
        orderRepository.save(new ProductOrder(null, dto.getProductId(), dto.getUserId(), dto.getQuantity(),
            dto.getPrice()));
    }

    // 재고량 유무
    private boolean isLessThanStock(Long productId, int orderQuantity) {
        int stockQuantity = productRepository.findById(productId).orElseThrow().getStock();
        return orderQuantity <= stockQuantity;
    }

    // 총 금액 맞는지 여부
    private boolean isValidPrice(Long productId, int unverifiedTotalPrice, int orderQuantity) {
        Product product = productRepository.findById(productId).orElseThrow();
        int price = product.getPrice();
        EventBadge eventBadge = product.getEventBadge();
        int verifiedTotalPrice = orderQuantity * ((price * (100 - eventBadge.getDiscountRate()))/1000 * 10);
        log.info("verifiedTotalPrice={}", verifiedTotalPrice);
        return unverifiedTotalPrice == verifiedTotalPrice;
    }
}
