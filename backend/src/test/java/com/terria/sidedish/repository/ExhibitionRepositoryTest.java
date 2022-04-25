package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.aggregate.Exhibition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ExhibitionRepositoryTest {

    @Autowired
    ExhibitionRepository exhibitionRepository;

    @Test
    void findByExhibitionId() {
        Optional<Exhibition> exhibition = exhibitionRepository.findById(2L);
        assertThat(exhibition).isNotEmpty();
    }
}
