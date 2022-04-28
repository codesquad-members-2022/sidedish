package team31.codesuqad.sidedish.repository;

import org.springframework.data.repository.CrudRepository;
import team31.codesuqad.sidedish.domain.Deliveries;

import java.util.Optional;

public interface DeliveriesRepository extends CrudRepository<Deliveries, Integer> {

    Optional<Deliveries> findById(Integer id);

}
