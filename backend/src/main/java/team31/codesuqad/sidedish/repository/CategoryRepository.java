package team31.codesuqad.sidedish.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import team31.codesuqad.sidedish.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Override
    List<Category> findAll();
}
