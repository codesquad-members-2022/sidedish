package kr.codesquad.sidedish.service;

import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.dto.DishDetailResponse;
import kr.codesquad.sidedish.dto.DishRecommendation;
import kr.codesquad.sidedish.dto.DishSimpleResponse;
import kr.codesquad.sidedish.exception.BusinessException;
import kr.codesquad.sidedish.exception.ErrorCode;
import kr.codesquad.sidedish.repository.JdbcDishRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    private final JdbcDishRepository jdbcDishRepository;

    public DishService(JdbcDishRepository jdbcDishRepository) {
        this.jdbcDishRepository = jdbcDishRepository;
    }

    public DishDetailResponse findOne(Long id) {
        Dish dish = jdbcDishRepository.findById(id)
            .orElseThrow(() -> new BusinessException(ErrorCode.NoDishError));

        return DishDetailResponse.from(dish);
    }

    public List<DishRecommendation> findDishRecommendations(Long id) {
        Dish dish = jdbcDishRepository.findById(id)
            .orElseThrow(() -> new BusinessException(ErrorCode.NoDishError));
        Long categoryId = dish.getCategoryId();

        List<Dish> dishesByOtherCategoryId = jdbcDishRepository.findDishesByOtherCategoryId(
            categoryId);

        return dishesByOtherCategoryId.stream()
            .map(DishRecommendation::from)
            .collect(Collectors.toList());
    }

}
