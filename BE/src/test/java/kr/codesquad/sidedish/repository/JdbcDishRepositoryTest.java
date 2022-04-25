package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Dish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.Assertions.*;

@DataJdbcTest
class JdbcDishRepositoryTest {

    @Autowired
    private JdbcDishRepository jdbcDishRepository;

    @Test
    void softDelete() {
        boolean isDeleted = jdbcDishRepository.delete(1L);
        assertThat(isDeleted).isTrue();
    }

    @Test
    void find_dish_with_image() {
        Dish dish = jdbcDishRepository.findById(1L).orElseThrow();
    }

    @Test
    void find_dishes_with_image() {
        List<Dish> dishesByCategoryId = jdbcDishRepository.findDishesByCategoryId(1L);
    }

    @Test
    void findDishesByCategoryId2() {

        PageRequest pageRequest = PageRequest.of(0, 4);

        List<Dish> dishesByCategoryId = jdbcDishRepository.findDishesByCategoryId(1L, pageRequest);
    }
}
