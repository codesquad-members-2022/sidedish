package com.codesquad.sidedish;

import static org.assertj.core.api.BDDAssertions.then;

import com.codesquad.sidedish.dish.Dish;
import com.codesquad.sidedish.dish.DishRepository;
import com.codesquad.sidedish.dish.EventBadge;
import com.codesquad.sidedish.dish.EventBadgeRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Sql("classpath:sql/schema.sql")
@DisplayName("DishRepository 통합 테스트")
public class DishRepositoryTest {

    @Autowired
    DishRepository dishRepository;

    @Autowired
    EventBadgeRepository eventBadgeRepository;

    @Test
    @Rollback(false)
    @DisplayName("Dish 엔티티를 저장하고 조회한다")
    public void saveTest() {
        // given
        EventBadge eventBadge = new EventBadge("이벤트 뱃지 이름", 20F);
        eventBadgeRepository.save(eventBadge);

        Dish dish = new Dish("반찬 이름", "반찬 설명", 10_000, 0);
        dish.setEventBadge(eventBadge);
        dishRepository.save(dish);

        // when
        Optional<Dish> optionalDish = dishRepository.findByIdWithEventBadge(dish.getId());

        // then
        then(optionalDish).hasValueSatisfying(findDish -> {
            then(findDish.getTitle()).isEqualTo("반찬 이름");
            then(findDish.getDescription()).isEqualTo("반찬 설명");
            then(findDish.getPrice()).isEqualTo(10_000);
            then(findDish.getStock()).isEqualTo(0);

            EventBadge findEventBadge = findDish.getEventBadge();
            then(findEventBadge.getEventBadgeName()).isEqualTo("이벤트 뱃지 이름");
            then(findEventBadge.getDiscount()).isEqualTo(20F);
        });
    }
}
