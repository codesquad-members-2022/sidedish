package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
