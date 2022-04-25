package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Item;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query(" SELECT item_id, category_id, item_name, description, original_price, discount_price, label_id, main_image, delivery_id, best_id " +
           " FROM item WHERE category_id = :category_id ")
    List<Item> findItemByCategoryId(@Param("category_id") Long categoryId);

    @Query("SELECT item_id, item_name, description, original_price, discount_price, label_id, main_image, delivery_id" +
            " from item WHERE best_id = :best_id ORDER BY label_id DESC;")
    List<Item> findByBestId(@Param("best_id") int bestId);
}
