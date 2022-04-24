package com.codesquad.sidedish;

import com.codesquad.sidedish.event_badge.EventBadgeRepository;
import com.codesquad.sidedish.event_badge.domain.EventBadge;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DisplayName("EventBadgeRepository 조회 테스트")
public class EventBadgeRepositoryTest {

    @Autowired
    EventBadgeRepository eventBadgeRepository;

    @Test
    @DisplayName("저장된 초기 데이터를 조회한다")
    public void readTest() {
        List<EventBadge> eventBadges = eventBadgeRepository.findAll();

        System.out.println("eventBadges = " + eventBadges);
    }

}
