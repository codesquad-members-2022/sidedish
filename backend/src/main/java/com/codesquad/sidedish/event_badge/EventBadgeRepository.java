package com.codesquad.sidedish.event_badge;

import com.codesquad.sidedish.event_badge.domain.EventBadge;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventBadgeRepository extends CrudRepository<EventBadge, Integer> {

    @Override
    List<EventBadge> findAll();
}
