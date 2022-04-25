package kr.codesquad.sidedish.repository;

import java.util.List;
import kr.codesquad.sidedish.domain.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, Long> {

	@Override
	List<Theme> findAll();
}
