package com.sidedish.servcie;

import com.sidedish.domain.Image;
import com.sidedish.domain.product.*;
import com.sidedish.repository.MemberRepository;
import com.sidedish.repository.OrderProductRepository;
import com.sidedish.repository.OrderRepository;
import com.sidedish.repository.ProductRepository;
import com.sidedish.web.dto.CategoryProductDto;
import com.sidedish.web.dto.ImageDto;
import com.sidedish.web.dto.OrderDto;
import com.sidedish.web.dto.ProductDetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final OrderProductRepository orderProductRepository;

    @Transactional
    public void save(OrderDto orderDto) {
        Product product = productRepository.findById(orderDto.getProductId()).get();
        product.removeStock(orderDto.getQuantity());
        OrderProduct orderProduct = OrderProduct.builder().product(product).quantity(orderDto.getQuantity()).price(orderDto.getPrice()).build();
        Order order = Order.builder().member(memberRepository.getById(orderDto.getMemberId())).quantity(orderDto.getQuantity()).price(orderDto.getPrice()).build();
        orderProduct.setOrder(order);
        orderProductRepository.save(orderProduct);
        orderRepository.save(order);
        productRepository.save(product);
    }

    public List<CategoryProductDto> findMainCategory(String category){
        List<Product> products = productRepository.findAllByMainCategory(MainCategory.valueOf(category));
        List<CategoryProductDto> dtoList = makeEntityToDto(products);
        return dtoList;
    }

    public List<CategoryProductDto> findEventCategory(String category){
        List<Product> products = productRepository.findAllByEventCategory(EventCategory.valueOf(category));
        List<CategoryProductDto> dtoList = makeEntityToDto(products);
        return dtoList;
    }

    public ProductDetailDto findOne(Long productId){
        Product product = productRepository.findById(productId).orElseThrow(IllegalStateException::new);
        List<ImageDto> images = new ArrayList<>();
        for (Image image : product.getImage()) {
            images.add(new ImageDto(image.getId(), image.getImagePath()));
        }
        return ProductDetailDto.builder().productName(product.getProductName()).earlyDelivery(product.isEarlyDelivery()).price(product.getPrice()).eventBadge(product.getEventBadge()).discountRate(product.getEventBadge().getDiscountRate()).image(images).build();
    }


    private List<CategoryProductDto> makeEntityToDto(List<Product> products) {
        List<CategoryProductDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            String thumbnail = product.getImage().stream().findFirst().get().getImagePath();
            dtoList.add(CategoryProductDto.builder().id(product.getId()).productName(product.getProductName()).description(product.getDescription()).earlyDelivery(product.isEarlyDelivery()).price(product.getPrice()).eventBadge(product.getEventBadge()).discountRate(product.getEventBadge().getDiscountRate()).imageThumbnail(thumbnail).build());
        }
        return dtoList;
    }

}
