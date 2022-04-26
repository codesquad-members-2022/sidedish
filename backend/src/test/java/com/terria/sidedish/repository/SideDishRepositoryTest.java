package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.aggregate.SideDish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SideDishRepositoryTest {

    @Autowired
    SideDishRepository sideDishRepository;

    @Test
    void findById() {
        Optional<SideDish> sideDish = sideDishRepository.findById(1L);
        assertThat(sideDish).isNotEmpty();
    }
}
