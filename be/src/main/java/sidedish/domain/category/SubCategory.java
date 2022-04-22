package sidedish.domain.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class SubCategory {

    @Id
    private Long id;
    private Long mainCategoryId;
    private String title;
}
