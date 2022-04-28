package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Order;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Modifying
    @Query("UPDATE item SET stock = :stock WHERE item_id = :item_id")
    boolean updateStock(@Param("stock") Integer stock, @Param("item_id") Long itemId);
}

//    order_id    BIGINT AUTO_INCREMENT NOT NULL,
//        item_id     BIGINT NOT NULL,
//        user_id     BIGINT NOT NULL,
//        quantity    INTEGER NOT NULL,
//        total_price BIGINT NOT NULL,
