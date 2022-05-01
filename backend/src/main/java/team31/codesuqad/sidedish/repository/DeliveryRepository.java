package team31.codesuqad.sidedish.repository;

import org.springframework.data.repository.CrudRepository;
import team31.codesuqad.sidedish.domain.Delivery;

import java.util.Optional;

public interface DeliveryRepository extends CrudRepository<Delivery, Integer> {

    Optional<Delivery> findById(Integer id);

}
