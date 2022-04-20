package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcImageRepository extends CrudRepository<Image, Long> {

}
