package com.sidedish.mapper;

import com.sidedish.domain.SideDish;
import com.sidedish.domain.UserOrder;
import com.sidedish.dto.SideDishDto;
import com.sidedish.dto.SideDishOrderDto;
import java.time.LocalDateTime;

public class UserOrderMapper {

    public static UserOrder convertToDomain(SideDishOrderDto sideDishOrderDto, Integer userId) {
        return new UserOrder(null, userId, sideDishOrderDto.getSidedishId(),
            sideDishOrderDto.getQuantity(), sideDishOrderDto.getTotalPrice(),
            sideDishOrderDto.getFee(), sideDishOrderDto.getPoint(), LocalDateTime.now(),
            LocalDateTime.now());
    }

}
