package com.terria.sidedish.repository;

import com.terria.sidedish.domain.Category;
import com.terria.sidedish.domain.DiscountEvent;
import com.terria.sidedish.domain.SideDishImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SideDishImageRepository sideDishImageRepository;
    @Autowired
    DiscountEventRepository discountEventRepository;

/*    @Test
    void findByExhibitionId() {
        List<Category> categories = categoryRepository.findByExhibitionId(1L);
        assertThat(categories).isNotNull();
    }*/

    @Test
    void 반찬_이미지_1개_조회() {
        Optional<SideDishImage> sideDishImage = sideDishImageRepository.findByIdAndImageSeq(1L, 1);

        System.out.println(sideDishImage.get().toString());

        assertThat(sideDishImage).isNotEmpty();
    }

    @Test
    void 반찬의_이벤트_가져오기() {
        List<DiscountEvent> events = discountEventRepository.findAllBySideDishId(1L);

        for (DiscountEvent event : events) {
            System.out.println(event.toString());
        }

        assertThat(events).isNotEmpty();
    }

}