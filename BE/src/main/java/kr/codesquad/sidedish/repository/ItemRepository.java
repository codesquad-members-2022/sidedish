package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
