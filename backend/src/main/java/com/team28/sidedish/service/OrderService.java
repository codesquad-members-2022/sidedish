package com.team28.sidedish.service;

import com.team28.sidedish.exception.OutOfStockException;
import com.team28.sidedish.exception.ProductNotFoundException;
import com.team28.sidedish.repository.OrderProductsRepository;
import com.team28.sidedish.repository.OrdersRepository;
import com.team28.sidedish.repository.ProductRepository;
import com.team28.sidedish.repository.entity.OrderProductsEntity;
import com.team28.sidedish.repository.entity.OrdersEntity;
import com.team28.sidedish.repository.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductRepository productRepository;
    private final OrdersRepository ordersRepository;
    private final OrderProductsRepository orderProductsRepository;

    private boolean isEnoughStockCount(Long productId, int quantity) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);

        return productEntity.getStockQuantity() >= quantity;
    }

    private void decreaseStock(Long productId, int quantity) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(ProductNotFoundException::new);

        productEntity.decreaseStock(quantity);
        productRepository.save(productEntity);
    }

    @Transactional
    public void order(Long productId, Long memberId, int quantity) {
        if (!isEnoughStockCount(productId, quantity)) {
            throw new OutOfStockException();
        }
        decreaseStock(productId, quantity);

        OrdersEntity savedOrder = ordersRepository.save(new OrdersEntity(memberId));
        OrderProductsEntity savedOrderProduct = orderProductsRepository.save(new OrderProductsEntity(null, savedOrder.getId(), productId, quantity));
        savedOrder.addOrderProducts(savedOrderProduct);
    }
}
