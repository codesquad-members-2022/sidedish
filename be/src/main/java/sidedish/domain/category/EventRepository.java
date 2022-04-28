package sidedish.domain.category;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sidedish.domain.item.Item;

@Repository
public interface EventRepository extends CrudRepository<EventCategory, Long> {

    List<EventCategory> findAll();
}
