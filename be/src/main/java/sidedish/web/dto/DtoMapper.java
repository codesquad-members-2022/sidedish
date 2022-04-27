package sidedish.web.dto;

import org.springframework.stereotype.Component;
import sidedish.domain.images.Image;
import sidedish.domain.item.Item;
import sidedish.web.dto.image.ResponseImagesDto;
import sidedish.web.dto.item.ResponseItemDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoMapper {

    public ResponseItemDto mapItemDomainToDto(Item item) {
        List<ResponseImagesDto> images = item.getImages().stream()
                .map(this::mapImageDomainToDto)
                .collect(Collectors.toList());
        return new ResponseItemDto(item, images);
    }

    public ResponseImagesDto mapImageDomainToDto(Image image) {
        return new ResponseImagesDto(image);
    }
}
