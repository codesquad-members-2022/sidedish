package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JdbcCategoryRepository extends CrudRepository<Category, Long> {

}
