package sidedish.domain.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MainCategory {

    @Id
    private Long id;
    private String title;
    @MappedCollection(idColumn = "main_category_id", keyColumn = "id")
    private List<SubCategory> subCategories;
}
