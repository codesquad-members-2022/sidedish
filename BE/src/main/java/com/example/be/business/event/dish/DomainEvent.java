package com.example.be.business.event.dish;

import com.example.be.business.event.Event;
import com.example.be.business.event.common.EventType;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.relational.core.mapping.Table;

public class DomainEvent<T> implements Event {

    private static final String DOMAIN_EVENT = "메세지 큐에 저장되는 도메인 이벤트";

    private Long id;
    private EventType eventType;
    private T data;

    public DomainEvent(EventType eventType, T data) {
        this.eventType = eventType;
        this.data = data;
    }

    public DomainEvent() {
    }

    public Long getId() {
        return id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public T getData() {
        return data;
    }
}
