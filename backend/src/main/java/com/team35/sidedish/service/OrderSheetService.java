package com.team35.sidedish.service;

import com.team35.sidedish.domain.entity.aggregate.OrderSheet;
import com.team35.sidedish.domain.entity.aggregate.SideDish;
import com.team35.sidedish.dto.request.OrderSheetRequest;
import com.team35.sidedish.dto.response.OrderSheetResponse;
import com.team35.sidedish.error.exception.OrderException;
import com.team35.sidedish.repository.OrderSheetRepository;
import com.team35.sidedish.repository.SideDishRepository;
import com.team35.sidedish.error.ErrorCode;
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
            .orElseThrow(() -> new OrderException(ErrorCode.NO_SUCH_SIDE_DISH_ERROR));

        int remainStock = sideDish.getStock();
        if (remainStock < orderQuantity) {
            throw new OrderException(ErrorCode.NOT_AVAILABLE_ORDER_FOR_NO_STOCK);
        }

        sideDishRepository.updateStockById(sideDishId, remainStock - orderQuantity);
        OrderSheet orderSheet = orderSheetRepository.save(orderSheetRequest.toEntity());

        return OrderSheetResponse.from(orderSheet);
    }
}
