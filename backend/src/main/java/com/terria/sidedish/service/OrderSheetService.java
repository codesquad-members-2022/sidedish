package com.terria.sidedish.service;

import com.terria.sidedish.domain.entity.aggregate.OrderSheet;
import com.terria.sidedish.domain.entity.aggregate.SideDish;
import com.terria.sidedish.dto.request.OrderSheetRequest;
import com.terria.sidedish.dto.response.OrderSheetResponse;
import com.terria.sidedish.error.ErrorCode;
import com.terria.sidedish.error.exception.OrderException;
import com.terria.sidedish.repository.OrderSheetRepository;
import com.terria.sidedish.repository.SideDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@RequiredArgsConstructor
public class OrderSheetService {

    private final OrderSheetRepository orderSheetRepository;
    private final SideDishRepository sideDishRepository;

    @Transactional
    public OrderSheetResponse addOrderSheet(@ModelAttribute OrderSheetRequest orderSheetRequest) {
        long sideDishId = orderSheetRequest.getSideDishId();
        int orderQuantity = orderSheetRequest.getQuantity();

        SideDish sideDish = sideDishRepository.findById(sideDishId)
            .orElse(null);

        int remainStock = sideDish.getStock();
        if (remainStock < orderQuantity) {
            throw new OrderException(ErrorCode.NOT_AVAILABLE_ORDER_FOR_NO_STOCK);
        }

        sideDishRepository.updateStockById(sideDishId, remainStock - orderQuantity);
        OrderSheet orderSheet = orderSheetRepository.save(orderSheetRequest.toEntity());

        return OrderSheetResponse.from(orderSheet);
    }
}
