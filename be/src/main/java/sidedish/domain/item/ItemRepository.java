package sidedish.domain.item;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("select * from item where main_category_id = :category_id")
    List<Item> findItemsById(@Param("category_id") Long categoryId);

    @Query("select i.id, i.title, i.description, i.price, i.quantity, i.discount_policy, i.morning_delivery"
            + " from item_event AS ie join item AS i on ie.item_id = i.id WHERE ie.event_id = :event_id")
    List<Item> findItemsByEventId(@Param("event_id") Long eventId);
}
