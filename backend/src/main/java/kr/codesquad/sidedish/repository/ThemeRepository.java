package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ThemeRepository extends CrudRepository<Theme, Long> {

    @Override
    List<Theme> findAll();
}
