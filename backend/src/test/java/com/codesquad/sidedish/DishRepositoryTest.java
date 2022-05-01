package com.codesquad.sidedish;


import com.codesquad.sidedish.dish.DishRepository;
import com.codesquad.sidedish.dish.domain.Dish;
import com.codesquad.sidedish.other.page.Criteria;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.ActiveProfiles;


@DataJdbcTest
@ActiveProfiles({"local"})
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DisplayName("DishRepository 조회 테스트")
public class DishRepositoryTest {

    @Autowired
    DishRepository dishRepository;

    @Test
    @DisplayName("저장된 초기 데이터를 모두 조회한다")
    public void readAllTest() {
        Criteria criteria = new Criteria(1, 4);

        List<Dish> sectionDishes = dishRepository.findBySectionName(
            "든든한 메인요리", criteria.getLimit(), criteria.getOffset());

        System.out.println("dishes = " + sectionDishes);

        List<Dish> categoryDishes = dishRepository.findByCategoryName(
            "국/탕/찌개", criteria.getLimit(), criteria.getOffset());

        System.out.println("dishes = " + categoryDishes);
    }

    @Test
    @DisplayName("저장된 초기 데이터를 1개 조회한다")
    public void readOneTest() {
        Optional<Dish> optional = dishRepository.findById(1);

        System.out.println(optional);
    }
}
