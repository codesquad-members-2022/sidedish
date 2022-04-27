package com.terria.sidedish.service;

import com.terria.sidedish.domain.entity.aggregate.OrderSheet;
import com.terria.sidedish.dto.request.OrderSheetRequest;
import com.terria.sidedish.repository.OrderSheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@RequiredArgsConstructor
public class OrderSheetService {

    private final OrderSheetRepository orderSheetRepository;

    public OrderSheet addOrderSheet(@ModelAttribute OrderSheetRequest orderSheetRequest) {
        return orderSheetRepository.save(orderSheetRequest.toEntity());
    }
}
