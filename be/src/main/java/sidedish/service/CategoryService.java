package sidedish.service;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sidedish.domain.category.CategoryRepository;
import sidedish.domain.category.MainCategory;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public List<MainCategory> findCategories() {
        return Lists.newArrayList(categoryRepository.findAll());
    }

}
