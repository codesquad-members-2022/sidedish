package com.codesquad.sidedish;

import com.codesquad.sidedish.category.CategoryRepository;
import com.codesquad.sidedish.category.domain.Category;
import java.util.List;
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
@DisplayName("CategoryRepositoryTest 조회 테스트")
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @DisplayName("저장된 초기 데이터를 조회한다")
    public void readTest() {
        List<Category> categories = categoryRepository.findBySectionName("든든한 메인요리");

        System.out.println("categories = " + categories);
    }
}
