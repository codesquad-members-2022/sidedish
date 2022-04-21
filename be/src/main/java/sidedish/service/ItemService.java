package sidedish.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sidedish.domain.images.Image;
import sidedish.domain.images.ImageRepository;
import sidedish.domain.item.Item;
import sidedish.domain.item.ItemRepository;
import sidedish.web.dto.item.ResponseItemDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ImageRepository imageRepository;

    public ResponseItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        List<Image> images = imageRepository.findImagesById(item.getId());

        return mapItemToDto(item, images);
    }

    private ResponseItemDto mapItemToDto(Item item, List<Image> images) {
        String mainImageUrl = images.stream()
                .filter(Image::isMainStatus)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getUrl();

        List<String> tabList = images.stream()
                .filter((i) -> !i.isMainStatus())
                .map(i -> i.getUrl())
                .collect(Collectors.toList());

        return new ResponseItemDto(item, mainImageUrl, tabList);
    }
}
