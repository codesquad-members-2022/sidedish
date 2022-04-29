package com.team35.sidedish.repository;

import com.team35.sidedish.domain.entity.aggregate.OrderSheet;
import org.springframework.data.repository.CrudRepository;

public interface OrderSheetRepository extends CrudRepository<OrderSheet, Long> {

}
