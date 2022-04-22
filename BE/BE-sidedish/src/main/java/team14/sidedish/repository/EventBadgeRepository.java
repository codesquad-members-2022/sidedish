package team14.sidedish.repository;

import org.springframework.data.repository.CrudRepository;

import team14.sidedish.domain.EventBadge;

public interface EventBadgeRepository extends CrudRepository<EventBadge, Long> {
}
