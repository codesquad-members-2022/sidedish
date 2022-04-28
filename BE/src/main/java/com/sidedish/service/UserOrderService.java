package com.sidedish.service;

import com.sidedish.domain.UserOrder;
import com.sidedish.dto.SideDishOrderDto;
import com.sidedish.mapper.UserOrderMapper;
import com.sidedish.repository.SideDishRepository;
import com.sidedish.repository.UserOrderRepository;
import com.sidedish.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserOrderService {

    private final UserOrderRepository userOrderRepository;
    private final UserRepository userRepository;
    private final SideDishRepository sideDishRepository;

    @Transactional
    public void saveUserOrder(SideDishOrderDto sideDishOrderDto, String email, Integer changedStock) {
        Integer userId = userRepository.findIdByEmail(email);
        UserOrder userOrder = UserOrderMapper.convertToDomain(sideDishOrderDto, userId);
        sideDishRepository.updateStockOfSideDish(sideDishOrderDto.getSidedishId(), changedStock);
        userOrderRepository.save(userOrder);
    }
}
