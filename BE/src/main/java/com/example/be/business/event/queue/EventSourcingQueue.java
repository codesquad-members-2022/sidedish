package com.example.be.business.event.queue;

import com.example.be.business.event.common.AbstractAggregateRootz;
import com.example.be.business.event.dish.DomainEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class EventSourcingQueue {
    private BlockingQueue<DomainEvent<? extends AbstractAggregateRootz>> events = new LinkedBlockingQueue<>();

    public void save(DomainEvent<? extends AbstractAggregateRootz> event) {
        events.add(event);
    }

    /**
     * 데이터가 많이 없기 때문에 전체 데이터 조회
     */
    public List<DomainEvent<? extends AbstractAggregateRootz>> getEvents() {
        return new ArrayList<>(events);
    }
}
