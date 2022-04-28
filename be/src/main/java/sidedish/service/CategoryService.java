package sidedish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sidedish.domain.category.CategoryRepository;
import sidedish.domain.category.MainCategory;
import sidedish.domain.item.Item;
import sidedish.domain.item.ItemRepository;
import sidedish.web.dto.DtoMapper;
import sidedish.web.dto.item.ResponseItemDto;
import sidedish.web.dto.item.ResponseItemsDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;
    private final DtoMapper mapper;

    public List<MainCategory> findCategories() {
        return categoryRepository.findAll();
    }

    public ResponseItemsDto findCategoryItems(Long categoryId) {
        List<Item> items = itemRepository.findItemsById(categoryId);
        MainCategory mainCategory = categoryRepository.findById(categoryId).orElseThrow();
        List<ResponseItemDto> contents = items.stream()
                .map(mapper::mapItemDomainToDto)
                .collect(Collectors.toList());

        return new ResponseItemsDto(categoryId, mainCategory.getTitle(), contents);
    }
}
