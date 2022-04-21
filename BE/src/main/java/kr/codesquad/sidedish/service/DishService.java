package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.dto.DishDetailResponse;
import kr.codesquad.sidedish.dto.DishSimpleResponse;
import kr.codesquad.sidedish.repository.JdbcDishRepository;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    private final JdbcDishRepository jdbcDishRepository;

    public DishService(JdbcDishRepository jdbcDishRepository) {
        this.jdbcDishRepository = jdbcDishRepository;
    }

    public DishDetailResponse findOne(Long id) {
        Dish dish = jdbcDishRepository.findById(id).orElseThrow();

        return DishDetailResponse.from(dish);
    }
}
