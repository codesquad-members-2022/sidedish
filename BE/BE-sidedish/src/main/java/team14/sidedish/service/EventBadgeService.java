package team14.sidedish.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import team14.sidedish.domain.EventBadge;
import team14.sidedish.repository.EventBadgeRepository;

@RequiredArgsConstructor
@Service
public class EventBadgeService {
	private final EventBadgeRepository eventBadgeRepository;

	// 임시 테스트용
	private void test() {
		Iterable<EventBadge> all = eventBadgeRepository.findAll();
	}
}
