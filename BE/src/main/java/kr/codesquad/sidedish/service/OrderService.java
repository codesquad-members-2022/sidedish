package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.dto.OrderRequest;
import kr.codesquad.sidedish.dto.Reciept;
import kr.codesquad.sidedish.repository.JdbcDishRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final JdbcDishRepository jdbcDishRepository;

    public OrderService(JdbcDishRepository jdbcDishRepository) {
        this.jdbcDishRepository = jdbcDishRepository;
    }

    public void isOrderPlaceable(OrderRequest orderRequest) {
        Long dishId = orderRequest.getDishId();
        Dish dish = jdbcDishRepository.findById(dishId).orElseThrow();
        if (dish.getStock() < orderRequest.getQuantity()) {
            throw new IllegalArgumentException("주문 오류");
        }
    }

    public Reciept placeOrder(OrderRequest orderRequest) {
        Long dishId = orderRequest.getDishId();
        int quantity = orderRequest.getQuantity();
        jdbcDishRepository.updateStock(dishId, quantity);
        Dish dish = jdbcDishRepository.findById(dishId).orElseThrow();
        return new Reciept(orderRequest.getUserEmail(), dish.getName(),
                quantity, dish.getDiscountPrice() * quantity);
    }


}
