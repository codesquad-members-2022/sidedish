package kr.codesquad.sidedish.service;

import java.util.stream.Collectors;

import kr.codesquad.sidedish.domain.Category;
import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.dto.CategorizedDishes;
import kr.codesquad.sidedish.dto.DishSimpleResponse;
import kr.codesquad.sidedish.exception.BusinessException;
import kr.codesquad.sidedish.exception.ErrorCode;
import kr.codesquad.sidedish.repository.JdbcCategoryRepository;
import kr.codesquad.sidedish.repository.JdbcDishRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CategoryService {

    private final JdbcDishRepository jdbcDishRepository;
    private final JdbcCategoryRepository jdbcCategoryRepository;

    public CategoryService(JdbcDishRepository jdbcDishRepository,
        JdbcCategoryRepository jdbcCategoryRepository) {
        this.jdbcDishRepository = jdbcDishRepository;
        this.jdbcCategoryRepository = jdbcCategoryRepository;
    }

    @Transactional(readOnly = true)
    public CategorizedDishes findDishesByCategoryId(Long categoryId, int page, int size) {
        Category category = jdbcCategoryRepository.findById(categoryId)
            .orElseThrow(() -> new BusinessException(ErrorCode.NoCategoryError));

        PageRequest pageRequest = PageRequest.of(page, size);
        List<Dish> dishesByCategoryId = jdbcDishRepository.findDishesByCategoryId(category.getId(), pageRequest);
        List<DishSimpleResponse> dishSimpleResponses = dishesByCategoryId
                .stream()
                .map(DishSimpleResponse::of)
                .collect(Collectors.toList());

        return new CategorizedDishes(category, dishSimpleResponses);
    }
}
