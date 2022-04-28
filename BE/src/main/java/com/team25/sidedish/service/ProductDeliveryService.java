package com.team25.sidedish.service;

import com.team25.sidedish.domain.Delivery;
import com.team25.sidedish.exception.NotFoundException;
import com.team25.sidedish.repository.ProductDeliveryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductDeliveryService {

    private final ProductDeliveryRepository productDeliveryRepository;

    public List<Delivery> getDeliveriesByProductId(Long productId) {
        return productDeliveryRepository.findDeliveriesByProductId(productId)
            .orElseThrow(NotFoundException::new);
    }
}
