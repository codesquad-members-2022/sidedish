package com.team34.sidedish.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.team34.sidedish.domain.Dish;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DishRepositoryTest {

    @Autowired
    private DishRepository dishRepository;

    @Test
    void findById() {
        Optional<Dish> dish = dishRepository.findById(1L);
        assertThat(dish).isNotEmpty()
            .get()
            .hasFieldOrPropertyWithValue("title", "오리 주물럭_반조리");
    }
}
