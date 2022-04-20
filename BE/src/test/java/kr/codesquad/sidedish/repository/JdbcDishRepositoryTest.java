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

    }

    @Test
    void softDelete() {
        boolean isDeleted = jdbcDishRepository.softDelete(1L);

        Assertions.assertThat(isDeleted).isTrue();

    }
}
