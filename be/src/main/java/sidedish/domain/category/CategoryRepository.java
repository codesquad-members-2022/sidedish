package sidedish.domain.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<MainCategory,Long> {

    List<MainCategory> findAll();
}
