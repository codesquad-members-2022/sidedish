package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.controller.dto.CategoryListResponse;
import kr.codesquad.sidedish.domain.Category;
import kr.codesquad.sidedish.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryListResponse readAll() {
        List<Category> categories = StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return new CategoryListResponse(categories);
    }
}
