package com.sidedish.api.categories;

import com.sidedish.domain.Badge;
import com.sidedish.domain.Category;
import com.sidedish.domain.CategoryType;
import com.sidedish.domain.Item;
import com.sidedish.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;


@RequiredArgsConstructor
@Component
public class initDB {

    private final InitService initService;

    @PostConstruct
    void init() {
        initService.init();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final CategoryRepository categoryRepository;

        public void init(){
            Category mainCategory = new Category(CategoryType.MAIN);
            Category sidedishCategory = new Category(CategoryType.SIDE);

            Item newItem1 = new Item("고기1", "맛있는 고기1", BigDecimal.valueOf(10000),
                    10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html");

            Item newItem2 = new Item("고기2", "맛있는 고기2", BigDecimal.valueOf(10000),
                    10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html");

            Item newItem3 = new Item("고기3", "맛있는 고기3", BigDecimal.valueOf(10000),
                    10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html");

            mainCategory.saveItem(newItem1);
            mainCategory.saveItem(newItem2);
            mainCategory.saveItem(newItem3);

            Item newItem4 = new Item("콩나물1", "맛있는 콩나물1", BigDecimal.valueOf(10000),
                    10.0, Badge.EVENT, "풍성한 콩나물 반찬", 10, BigDecimal.valueOf(100), "html");

            Item newItem5 = new Item("콩나물2", "맛있는 콩나물2", BigDecimal.valueOf(10000),
                    10.0, Badge.EVENT, "풍성한 콩나물 반찬", 10, BigDecimal.valueOf(100), "html");

            Item newItem6 = new Item("콩나물3", "맛있는 콩나물3", BigDecimal.valueOf(10000),
                    10.0, Badge.EVENT, "풍성한 콩나물 반찬", 10, BigDecimal.valueOf(100), "html");

            sidedishCategory.saveItem(newItem4);
            sidedishCategory.saveItem(newItem5);
            sidedishCategory.saveItem(newItem6);

            categoryRepository.save(mainCategory);
            categoryRepository.save(sidedishCategory);
        }
    }
}
