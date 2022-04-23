package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
