package team31.codesuqad.sidedish.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import team31.codesuqad.sidedish.domain.EventTabs;

public interface EventTabsRepository extends CrudRepository<EventTabs, Integer> {

    EventTabs findByName(@Param("name") String name);
}
