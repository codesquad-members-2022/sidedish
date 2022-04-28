package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.dto.OrderRequest;
import kr.codesquad.sidedish.dto.Reciept;
import kr.codesquad.sidedish.exception.BusinessException;
import kr.codesquad.sidedish.exception.ErrorCode;
import kr.codesquad.sidedish.repository.JdbcDishRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final JdbcDishRepository jdbcDishRepository;

    public OrderService(JdbcDishRepository jdbcDishRepository) {
        this.jdbcDishRepository = jdbcDishRepository;
    }

    public void checkOrderPlaceable(Long dishId, OrderRequest orderRequest) {
        Dish dish = jdbcDishRepository.findById(dishId)
            .orElseThrow(() -> new BusinessException(ErrorCode.NoDishError));
        if (!dish.isOrderable(orderRequest.getQuantity())) {
            throw new BusinessException(ErrorCode.NotEnoughDishStockError);
        }
    }

    public Reciept placeOrder(Long dishId, OrderRequest orderRequest) {
        int quantity = orderRequest.getQuantity();
        jdbcDishRepository.updateStock(dishId, quantity);
        Dish dish = jdbcDishRepository.findById(dishId)
            .orElseThrow(() -> new BusinessException(ErrorCode.NoDishError));
        return new Reciept(orderRequest.getUserEmail(), dish.getName(),
            quantity, dish.getDiscountPrice() * quantity);
    }


}
