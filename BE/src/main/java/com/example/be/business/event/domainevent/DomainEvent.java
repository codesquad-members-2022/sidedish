package com.example.be.business.event.domainevent;

import com.example.be.business.event.user.UserEvent;

public class DomainEvent<T> implements UserEvent {

    private static final String DOMAIN_EVENT = "메세지 큐에 저장되는 도메인 이벤트";

    private Long id;
    private EventType eventType;
    private T data;

    public DomainEvent(Long id, EventType eventType, T data) {
        this.id = id;
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
