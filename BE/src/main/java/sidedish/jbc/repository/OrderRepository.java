package sidedish.jbc.repository;


import org.springframework.data.repository.CrudRepository;
import sidedish.jbc.domain.MenuOrder;

public interface OrderRepository extends CrudRepository<MenuOrder, Long> {

}
