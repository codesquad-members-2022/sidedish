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
            Category soupCategory = new Category(CategoryType.SOUP);

            createItem(mainCategory, "고기1", "풍성한고기반찬");
            createItem(mainCategory, "고기2", "풍성한고기반찬");
            createItem(mainCategory, "고기3", "풍성한고기반찬");
            createItem(mainCategory, "고기4", "풍성한고기반찬");
            createItem(mainCategory, "고기5", "풍성한고기반찬");
            createItem(mainCategory, "고기6", "풍성한고기반찬");

            createItem(soupCategory, "햄가득 부대찌개", "우리아이영양반찬");
            createItem(soupCategory, "햄가득 부대찌개", "우리아이영양반찬");
            createItem(soupCategory, "햄가득 부대찌개", "우리아이영양반찬");
            createItem(soupCategory, "햄가득 부대찌개", "우리아이영양반찬");

            createItem(sidedishCategory, "콩나물1", "편리한반찬세트");
            createItem(sidedishCategory, "콩나물2", "편리한반찬세트");
            createItem(sidedishCategory, "콩나물3", "편리한반찬세트");
            createItem(sidedishCategory, "콩나물4", "편리한반찬세트");
            createItem(sidedishCategory, "꼬막무침1", "맛있는제철요리");
            createItem(sidedishCategory, "꼬막무침2", "맛있는제철요리");
            createItem(sidedishCategory, "꼬막무침3", "맛있는제철요리");
            createItem(sidedishCategory, "꼬막무침4", "맛있는제철요리");


            categoryRepository.save(mainCategory);
            categoryRepository.save(soupCategory);
            categoryRepository.save(sidedishCategory);
        }
    }

    private static void createItem(Category mainCategory, String name, String detailtype) {
        Item newItem = new Item(name, "반찬 설명", BigDecimal.valueOf(10000),
                10.0, Badge.EVENT, detailtype, 10, BigDecimal.valueOf(100), "html");
        mainCategory.saveItem(newItem);
    }
}
