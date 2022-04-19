package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Dish;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class JdbcDishRepositoryTest {

    @Autowired
    private JdbcDishRepository jdbcDishRepository;

    private Dish dish;

    @BeforeEach
    void setUp() {

//        dish = new Dish(null,1L,"짱찬", 10, 10000,
//                "새벽배송", "정액할인");
//        Dish saved = jdbcDishRepository.save(dish);
    }

    @Test
    void softDelete() {
        boolean isDeleted = jdbcDishRepository.softDelete(1L);

        Assertions.assertThat(isDeleted).isTrue();

    }
}
