package sidedish.web.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class ResponseItemsDto {
    private Long id;
    private String title;
    private List<ResponseItemDto> contents;
}
