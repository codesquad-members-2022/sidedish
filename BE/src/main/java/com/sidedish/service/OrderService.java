package com.sidedish.service;

import com.sidedish.api.ResultDto;
import com.sidedish.domain.Item;
import com.sidedish.exception.QuantityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final ItemService itemService; // 질문 서비스 안에 다른 서비스가 있어도 되는가?

    public ResultDto order(Long id, int quantity) {
        Item orderItem = itemService.findItemById(id);

        if(!isValidQuntity(quantity, orderItem)) {
            throw new QuantityException();
        }

        orderItem.decreasedQuantity(quantity);
        itemService.updateItem(orderItem);
        return ResultDto.ok();
    }

    private boolean isValidQuntity(int quantity, Item orderItem) {
        return orderItem.getQuantity() - quantity > 0;
    }
}
