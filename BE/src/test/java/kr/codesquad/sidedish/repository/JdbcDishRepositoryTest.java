package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Dish;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJdbcTest
class JdbcDishRepositoryTest {

    @Autowired
    private JdbcDishRepository jdbcDishRepository;

    private Dish dish;

    @BeforeEach
    void setUp() {

    }

    @Test
    void softDelete() {
        boolean isDeleted = jdbcDishRepository.softDelete(1L);

        assertThat(isDeleted).isTrue();

    }

    @Test
    void find_dish_with_image() {
        Dish dish = jdbcDishRepository.findById(1L).orElseThrow();

        assertThat(dish.getImages()).hasSize(3);
        assertThat(dish.getCategoryId()).isEqualTo(1L);
        assertThat(dish.getEventId()).isEqualTo(1L);
        assertThat(dish.getImages().get(0).getName()).isEqualTo("짱민아침메인사진.jpg");
        assertThat(dish.getImages().get(1).getName()).isEqualTo("짱민아침서브사진.jpg");
        assertThat(dish.getImages().get(2).getName()).isEqualTo("짱민아침디테일사진.jpg");
        System.out.println(dish);
    }

    @Test
    void find_dishes_with_image() {
        List<Dish> dishesByCategoryId = jdbcDishRepository.findDishesByCategoryId(1L);

        for (Dish dish1 : dishesByCategoryId) {
            System.out.println(dish1);
        }
    }
}
