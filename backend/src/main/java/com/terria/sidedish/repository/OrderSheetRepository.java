package com.terria.sidedish.repository;

import com.terria.sidedish.domain.entity.aggregate.OrderSheet;
import org.springframework.data.repository.CrudRepository;

public interface OrderSheetRepository extends CrudRepository<OrderSheet, Long> {

}
