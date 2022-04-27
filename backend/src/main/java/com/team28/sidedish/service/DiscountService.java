package com.team28.sidedish.service;

import com.team28.sidedish.repository.DiscountRepository;
import com.team28.sidedish.repository.entity.DiscountEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiscountService {

    private final static DiscountEntity zeroRateDiscountEntity = new DiscountEntity(null, null, 0);

    private final DiscountRepository discountRepository;

    public DiscountEntity findDiscountById(Long discountId) {
        if (discountId == null) return zeroRateDiscountEntity;

        return discountRepository.findById(discountId)
                .orElse(zeroRateDiscountEntity);
    }

}
