package sidedish.web.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseItemsDto {
    private List<ResponseItemDto> items;
}
