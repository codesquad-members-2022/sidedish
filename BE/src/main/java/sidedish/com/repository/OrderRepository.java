package sidedish.com.repository;

import org.springframework.data.repository.CrudRepository;
import sidedish.com.repository.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

}
