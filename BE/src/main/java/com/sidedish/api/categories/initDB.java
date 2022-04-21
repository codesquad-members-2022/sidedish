package com.sidedish.api.categories;

import com.sidedish.domain.Badge;
import com.sidedish.domain.Category;
import com.sidedish.domain.CategoryType;
import com.sidedish.domain.Item;
import com.sidedish.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
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

            createItem(mainCategory, "고기1", "맛있는 고기1", CategoryType.MAIN); // page1
            createItem(mainCategory, "고기2", "맛있는 고기2", CategoryType.MAIN); // page1
            createItem(mainCategory, "고기3", "맛있는 고기3", CategoryType.MAIN); // page1
            createItem(mainCategory, "고기4", "맛있는 고기4", CategoryType.MAIN); // page1
            createItem(mainCategory, "고기5", "맛있는 고기5", CategoryType.MAIN); // page2
            createItem(mainCategory, "고기6", "맛있는 고기6", CategoryType.MAIN); // page2
//            createItem(mainCategory, "고기7", "맛있는 고기7", CategoryType.MAIN); // page2
//            createItem(mainCategory, "고기8", "맛있는 고기8", CategoryType.MAIN); // page2


            createItem(mainCategory, "콩나물1", "맛있는 콩나물1", CategoryType.SIDE); // page1
            createItem(mainCategory, "콩나물2", "맛있는 콩나물2", CategoryType.SIDE); // page1
            createItem(mainCategory, "콩나물3", "맛있는 콩나물3", CategoryType.SIDE); // page1
            createItem(mainCategory, "콩나물4", "맛있는 콩나물4", CategoryType.SIDE); // page1

            categoryRepository.save(mainCategory);
            categoryRepository.save(sidedishCategory);
        }
    }

    private static void createItem(Category mainCategory, String name, String desc, CategoryType type) {
        Item newItem = new Item(name, desc, BigDecimal.valueOf(10000),
                10.0, Badge.EVENT, "풍성한 고기 반찬", 10, BigDecimal.valueOf(100), "html", type);
        mainCategory.saveItem(newItem);
    }
}
