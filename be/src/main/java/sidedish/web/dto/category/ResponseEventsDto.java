package sidedish.web.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sidedish.domain.category.EventCategory;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseEventsDto {
    private List<EventCategory> eventCategories;
}
