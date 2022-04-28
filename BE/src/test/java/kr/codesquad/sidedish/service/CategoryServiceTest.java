package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.domain.Category;
import kr.codesquad.sidedish.domain.DeliveryType;
import kr.codesquad.sidedish.domain.DiscountPolicy;
import kr.codesquad.sidedish.dto.CategorizedDishes;
import kr.codesquad.sidedish.dto.DishDetailResponse;
import kr.codesquad.sidedish.dto.DishSimpleResponse;
import kr.codesquad.sidedish.repository.JdbcCategoryRepository;
import kr.codesquad.sidedish.repository.JdbcDishRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DataJdbcTest
@Sql("classpath:test-data.sql")
class CategoryServiceTest {
    private final CategoryService categoryService;
    @Autowired
    public CategoryServiceTest(JdbcCategoryRepository jdbcCategoryRepository, JdbcDishRepository jdbcDishRepository) {
        this.categoryService = new CategoryService(jdbcDishRepository, jdbcCategoryRepository);
    }

    @Test
    void findDishesByCategoryId() {
        //when
        CategorizedDishes categorizedDishes = categoryService.findDishesByCategoryId(4L,0 ,4);

        //then
        Category category = categorizedDishes.getCategory();
        List<DishSimpleResponse> dishes = categorizedDishes.getDishes();
        DishSimpleResponse dishSimpleResponse = dishes.get(0);

        assertThat(category.getId()).isEqualTo(4L);
        assertThat(category.getDescription()).isEqualTo("테스트카테고리입니다.");

        assertThat(dishes).hasSize(1);

        assertThat(dishSimpleResponse.getId()).isEqualTo(15L);
        assertThat(dishSimpleResponse.getDescription()).isEqualTo("테스트디쉬입니다.");
        assertThat(dishSimpleResponse.getName()).isEqualTo("테스트디쉬");
        assertThat(dishSimpleResponse.getNormalPrice()).isEqualTo(100);
        assertThat(dishSimpleResponse.getDiscountPrice()).isEqualTo(90);
        assertThat(dishSimpleResponse.getStock()).isEqualTo(1);
        assertThat(dishSimpleResponse.getImage()).isEqualTo("테스트1.jpg");
        assertThat(dishSimpleResponse.getDiscountPolicy()).isEqualTo(DiscountPolicy.이벤트특가);
        assertThat(dishSimpleResponse.getDeliveryType()).isEqualTo(DeliveryType.새벽배송);

    }
}
