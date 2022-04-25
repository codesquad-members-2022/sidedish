package kr.codesquad.sidedish.repository;

import java.util.List;
import kr.codesquad.sidedish.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	@Override
	List<Category> findAll();
}
