package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcEventRepository extends CrudRepository<Event, Long> {

}
