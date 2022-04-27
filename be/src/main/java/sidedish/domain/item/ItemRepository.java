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
}
