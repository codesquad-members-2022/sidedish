package com.example.be.business.event.queue;

import com.example.be.business.event.Event;
import com.example.be.business.event.domainevent.DomainEvent;
import com.example.be.business.event.user.UserEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

@Component
public class EventMessageQueue {
    private BlockingQueue<DomainEvent<? extends Event>> events = new LinkedBlockingQueue<>();

    public void save(DomainEvent<? extends UserEvent> event) {
        events.add(event);
    }

    /**
     * 데이터가 많이 없기 때문에 전체 데이터 조회
     */
    public List<DomainEvent<? extends Event>> getEvents() {
        return new ArrayList<>(events);
    }
}
