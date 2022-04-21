package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.MainCategory;
import kr.codesquad.sidedish.domain.Dish;
import kr.codesquad.sidedish.dto.CategorizedDishes;
import kr.codesquad.sidedish.repository.JdbcCategoryRepository;
import kr.codesquad.sidedish.repository.JdbcDishRepository;
import kr.codesquad.sidedish.repository.JdbcImageRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MainService {

    private final JdbcDishRepository jdbcDishRepository;
    private final JdbcImageRepository jdbcImageRepository;
    private final JdbcCategoryRepository jdbcCategoryRepository;

    public MainService(JdbcDishRepository jdbcDishRepository, JdbcImageRepository jdbcImageRepository, JdbcCategoryRepository jdbcCategoryRepository) {
        this.jdbcDishRepository = jdbcDishRepository;
        this.jdbcImageRepository = jdbcImageRepository;
        this.jdbcCategoryRepository = jdbcCategoryRepository;
    }

//    public Map<Long, List<DishSimpleResponse>> getAllDishes() {
//        MultiValueMap<Long, DishSimpleResponse> dishes = new LinkedMultiValueMap<>();
//
//        List<Dish> all = new ArrayList<>();
//        jdbcDishRepository.findAll().forEach(all::add);
//        MultiValueMap<Long, String> images = new LinkedMultiValueMap<>();
//        jdbcImageRepository.findAll().forEach(element -> images.add(element.getDishId(), element.getName()));
//
//        Map<Long, List<DishSimpleResponse>> map = new HashMap<>();
//
//        for (Dish dish : all) {
//            dishes.add(dish.getMainCategoryId(),
//                    DishSimpleResponse.of(dish, images.get(dish.getId())));
//        }
//        Set<Long> longs = dishes.keySet();
//
//        for (Long aLong : longs) {
//            map.put(aLong, dishes.get(aLong));
//        }
//
//        return map;
//    }

    public List<Dish> findAll() {
        List<Dish> dishes = new ArrayList<>();
        jdbcDishRepository.findAll().forEach(dishes::add);
        return dishes;
    }

    public CategorizedDishes find(Long mainCategoryId) {
        MainCategory category = jdbcCategoryRepository.findById(mainCategoryId).orElseThrow();

        List<Dish> dishesByMainCategoryId = jdbcDishRepository.findDishesByMainCategoryId(category.getId());

        return new CategorizedDishes(category, dishesByMainCategoryId);
    }
}
