package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.dto.DishSimpleResponse;
import kr.codesquad.sidedish.repository.JdbcCategoryRepository;
import kr.codesquad.sidedish.repository.JdbcDishRepository;
import kr.codesquad.sidedish.repository.JdbcImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

@Service
public class CategoryService {

    private final JdbcDishRepository jdbcDishRepository;
    private final JdbcImageRepository jdbcImageRepository;

    @Autowired
    public CategoryService( JdbcDishRepository jdbcDishRepository, JdbcImageRepository jdbcImageRepository) {
        this.jdbcDishRepository = jdbcDishRepository;
        this.jdbcImageRepository = jdbcImageRepository;
    }

    public MultiValueMap getAllDishes() {
        MultiValueMap<Long, DishSimpleResponse> dishes = new LinkedMultiValueMap<>();

        List<Dish> all = new ArrayList<>();
        jdbcDishRepository.findAll().forEach(element -> all.add(element));
        MultiValueMap<Long, String> images = new LinkedMultiValueMap<>();
        jdbcImageRepository.findAll().forEach(element -> images.add(element.getDishId(), element.getName()));

        for (Dish dish : all) {
            dishes.add(dish.getCategoryId(),
                       DishSimpleResponse.of(dish, images.get(dish.getId())));
        }

        return dishes;
    }


}
