package team31.codesuqad.sidedish.repository;

import org.springframework.data.repository.CrudRepository;
import team31.codesuqad.sidedish.domain.Event;

import java.util.List;
import java.util.Optional;

public interface EventTabRepository extends CrudRepository<Event, Integer> {

    Optional<Event> findByName(String name);

    @Override
    List<Event> findAll();

}
